package model.command;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import gui.tab.DBComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.CrimeRecord;

public abstract class LinkCommand implements Command {

	private Collection<?> inputs;
	private static final String SUCCESS_MESSAGE = "Successfully linked entries!";
	private static final String INCOMPLETE_MESSAGE = "Please choose all values.";
	private static final String FAILURE_MESSAGE = "Could not link entries.";

	public LinkCommand(Collection<?> inputs) {
		this.inputs = inputs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		List<DBComboBox<CrimeRecord>> boxes = inputs.stream().map(a -> (DBComboBox<CrimeRecord>) a).collect(Collectors.toList());
		if(boxes.get(0).getValue() == null || boxes.get(1).getValue() == null) {
			showMessage(AlertType.WARNING, INCOMPLETE_MESSAGE);
			return;
		}
		long record1 = boxes.get(0).getValue().getRecordNumber();
		long record2 = boxes.get(1).getValue().getRecordNumber();
		try {
			makeLink(record1, record2);
			showMessage(AlertType.CONFIRMATION, SUCCESS_MESSAGE);
		} catch(Exception e) {
			showMessage(AlertType.ERROR, FAILURE_MESSAGE);
		}
	}
	
	protected abstract void makeLink(long r1, long r2);
	
	private void showMessage(AlertType type, String message) {
		Alert successMessage = new Alert(type);
		successMessage.setContentText(message);
		successMessage.showAndWait();
	}

}
