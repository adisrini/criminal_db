package model.command;

import java.util.ArrayList;
import java.util.Collection;

import com.cinchapi.concourse.Concourse;

import gui.tab.DBNode;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.ConcourseManager;

public class AddEntryCommand implements Command {

	private Collection<?> inputs;
	private static final String SUCCESS_MESSAGE = "Successfully added your entry!";

	public AddEntryCommand(Collection<?> inputs) {
		this.inputs = inputs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		Concourse concourse = ConcourseManager.getInstance().concourse();
		int record_number = ((ArrayList<DBNode>) inputs).get(0).read().hashCode();
		inputs.stream().map(i -> (DBNode) i).forEach(a -> {
			String[] components = a.read().split("%");
			if (isBoolean(components[1])) {
				concourse.add(components[0], Boolean.parseBoolean(components[1]), record_number);
			} else {
				concourse.add(components[0], components[1], record_number);
			}
		});
		showSuccess();
	}
	
	private void showSuccess() {
		Alert successMessage = new Alert(AlertType.CONFIRMATION);
		successMessage.setContentText(SUCCESS_MESSAGE);
		successMessage.showAndWait();
	}

	private boolean isBoolean(String s) {
		return s.equals("true") || s.equals("false");
	}

}
