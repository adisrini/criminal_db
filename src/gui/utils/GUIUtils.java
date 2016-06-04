package gui.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Useful functions used for the GUI.
 * 
 * @author adityasrinivasan
 *
 */
public class GUIUtils {
	
	private static final double SPACING = 10;
	
	/**
	 * Returns an HBox constructed from the provided nodes, with spacing and padding defined.
	 * @param nodes
	 * @return
	 */
	public static HBox makeRow(Node... nodes) {
		HBox row = new HBox(SPACING);
		row.setPadding(new Insets(SPACING));
		row.getChildren().addAll(nodes);
		return row;
	}
	
	/**
	 * Returns a VBox constructed from the provided nodes, with spacing and padding defined.
	 * @param nodes
	 * @return
	 */
	public static VBox makeColumn(Node... nodes) {
		VBox col = new VBox(SPACING);
		col.setPadding(new Insets(SPACING));
		col.getChildren().addAll(nodes);
		return col;
	}
	
	/**
	 * Returns a button to look and act as specified.
	 * @param text: the text to display in the button
	 * @param ID: the button's ID
	 * @param e: the event handler to handle upon click
	 * @return the button
	 */
	public static Button makeButton(String text, String ID, EventHandler<ActionEvent> e) {
		Button button = new Button(text);
		button.setId(ID);
		button.setOnAction(e);
		button.setPadding(new Insets(SPACING));
		return button;
	}

}
