package gui.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUIUtils {
	
	private static final double SPACING = 10;
	
	public static HBox makeRow(Node... nodes) {
		HBox row = new HBox(SPACING);
		row.setPadding(new Insets(SPACING));
		row.getChildren().addAll(nodes);
		return row;
	}
	
	public static VBox makeColumn(Node... nodes) {
		VBox col = new VBox(SPACING);
		col.setPadding(new Insets(SPACING));
		col.getChildren().addAll(nodes);
		return col;
	}
	
	public static Button makeButton(String text, String ID, EventHandler<ActionEvent> e) {
		Button button = new Button(text);
		button.setId(ID);
		button.setOnAction(e);
		button.setPadding(new Insets(SPACING));
		return button;
	}

}
