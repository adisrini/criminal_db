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

public class GUIManager extends TabPane {

	private static final String ERROR_TITLE = "Error!";
	
	private EventHandler<ActionEvent> buttonEvent;
	private AbstractTab entryTab, connectionTab, queryTab;

	public void register(EventHandler<ActionEvent> buttonEvent) {
		this.buttonEvent = buttonEvent;
	}
	
	public void populateTabs() {
		entryTab = new DataEntryTab(buttonEvent);
		connectionTab = new DataConnectionTab(buttonEvent);
		queryTab = new DataExplorationTab(buttonEvent);
		this.getTabs().addAll(entryTab,
							  connectionTab,
							  queryTab);
		establishListener();
	}
	
	private void establishListener() {
		this.getSelectionModel().selectedItemProperty().addListener((obs, old, n) -> {
			if(n == connectionTab) {
				((DataConnectionTab) connectionTab).repopulateBoxes();
			} else if(n == queryTab) {
				((DataExplorationTab) queryTab).populateMap();
			}
		});
	}

	public Alert alert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(ERROR_TITLE);
		alert.setContentText(message);
		return alert;
	}

}