package controller;

import java.util.Collection;

import gui.GUIManager;
import gui.tab.AbstractTab;
import javafx.scene.Node;
import javafx.scene.control.TabPane;
import util.DBException;

/**
 * Establishes the button-handling mirror and the TabPane (GUIManager).
 * 
 * @author adityasrinivasan
 *
 */
public class DBController implements IController {
	
	private GUIManager gui;
	
	public DBController() {
		gui = new GUIManager();
		gui.register(e -> {
			try {
				Collection<?> inputs = ((AbstractTab) gui.getSelectionModel().getSelectedItem()).getInputs();
				ReflectiveHandler.handle(((Node) e.getSource()).getId(), inputs);
			} catch(DBException ex) {
				gui.alert(ex.getMessage()).show();
			}
		});
		gui.populateTabs();
	}

	@Override
	public TabPane getGUI() {
		return gui;
	}

}
