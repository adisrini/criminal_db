package gui.tab;

import gui.utils.CustomText;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DBField extends VBox {
	
	private static final double SPACING = 10;
	
	protected TextField myField;
	
	public DBField(String label, String prompt) {
		myField = new TextField();
		myField.setPromptText(prompt);
		
		this.getChildren().addAll(new CustomText(label), myField);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(SPACING));
	}

}
