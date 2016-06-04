package gui;

import gui.tab.AbstractTab;
import gui.tab.connection.DataConnectionTab;
import gui.tab.entry.DataEntryTab;
import gui.tab.query.DataExplorationTab;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TabPane;

/**
 * The GUIManager that instantiates each Tab and distributes the button events. It is a TabPane itself and is
 * responsible for overarching GUI components like alerts.
 * 
 * @author adityasrinivasan
 *
 */
public class GUIManager extends TabPane {

	private static final String ERROR_TITLE = "Error!";
	
	private EventHandler<ActionEvent> buttonEvent;
	private AbstractTab entryTab, connectionTab, queryTab;

	public void register(EventHandler<ActionEvent> buttonEvent) {
		this.buttonEvent = buttonEvent;
	}
	
	/**
	 * Initializes the tabs and adds them to the view.
	 */
	public void populateTabs() {
		entryTab = new DataEntryTab(buttonEvent);
		connectionTab = new DataConnectionTab(buttonEvent);
		queryTab = new DataExplorationTab(buttonEvent);
		this.getTabs().addAll(entryTab,
							  connectionTab,
							  queryTab);
		establishListener();
	}
	
	/**
	 * Establishes a tab listener to perform actions upon switching tabs.
	 */
	private void establishListener() {
		this.getSelectionModel().selectedItemProperty().addListener((obs, old, n) -> {
			if(n == connectionTab) {
				((DataConnectionTab) connectionTab).repopulateBoxes();
			} else if(n == queryTab) {
				((DataExplorationTab) queryTab).populateMap();
			}
		});
	}

	/**
	 * Displays an alert with the specified message.
	 * @param message
	 * @return
	 */
	public Alert alert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(ERROR_TITLE);
		alert.setContentText(message);
		return alert;
	}

}