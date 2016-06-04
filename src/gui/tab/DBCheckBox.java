package gui.tab;

import gui.utils.CustomText;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class DBCheckBox extends VBox {

	private static final double SPACING = 10;

	protected CheckBox xbox;
	
	public DBCheckBox(String label) {
		xbox = new CheckBox();
		this.getChildren().addAll(new CustomText(label), xbox);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(SPACING));
	}
	
}
