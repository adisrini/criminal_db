package model.command;

import java.util.ArrayList;
import java.util.Collection;

import com.cinchapi.concourse.Concourse;

import gui.tab.DBNode;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.ConcourseManager;

/**
 * Adds an entry to the database.
 * 
 * @author adityasrinivasan
 *
 */
public class AddEntryCommand implements Command {

	private static final String SUCCESS_MESSAGE = "Successfully added your entry!";
	private static final String SPLIT = "%";
	
	private Collection<?> inputs;

	public AddEntryCommand(Collection<?> inputs) {
		this.inputs = inputs;
	}

	/**
	 * Parses the input nodes and adds the fields to a record in the database.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		Concourse concourse = ConcourseManager.getInstance().concourse();
		int record_number = ((ArrayList<DBNode>) inputs).get(0).read().hashCode();
		inputs.stream().map(i -> (DBNode) i).forEach(a -> {
			String[] components = a.read().split(SPLIT);
			if (isBoolean(components[1])) {
				concourse.add(components[0], Boolean.parseBoolean(components[1]), record_number);
			} else {
				concourse.add(components[0], components[1], record_number);
			}
		});
		showSuccess();
	}
	
	/**
	 * Shows success upon execution.
	 */
	private void showSuccess() {
		Alert successMessage = new Alert(AlertType.CONFIRMATION);
		successMessage.setContentText(SUCCESS_MESSAGE);
		successMessage.showAndWait();
	}

	/**
	 * Determines if a String is representing a boolean value.
	 * @param s
	 * @return
	 */
	private boolean isBoolean(String s) {
		return s.equals("true") || s.equals("false");
	}

}
