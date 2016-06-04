package model.command;

import java.util.Collection;

import com.cinchapi.concourse.Concourse;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.ConcourseManager;
import model.CrimeRecord;

/**
 * Clears all entries from the database.
 * 
 * @author adityasrinivasan
 *
 */
public class ClearCommand implements Command {

	private Collection<?> inputs;
	private static final String SUCCESS_MESSAGE = "Successfully cleared all entries!";

	public ClearCommand(Collection<?> inputs) {
		this.inputs = inputs;
	}
	
	@Override
	public void execute() {
		Concourse concourse = ConcourseManager.getInstance().concourse();
		for(CrimeRecord record : ConcourseManager.getInstance().getRecords()) {
			concourse.clear(record.getRecordNumber());
		}
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

}
