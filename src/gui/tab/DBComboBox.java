package gui.tab;

import java.util.Collection;

import gui.utils.CustomText;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import util.TextFileReader;

public class DBComboBox<T> extends VBox {

	private static final double SPACING = 10;

	protected ComboBox<T> cbox;
	
	public DBComboBox(String label, String pathToItems, String delimiter) {
		this(label);
		populateCB(pathToItems, delimiter);
	}
	
	public DBComboBox(String label) {
		cbox = new ComboBox<>();
		this.getChildren().addAll(new CustomText(label), cbox);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(SPACING));
	}
	
	private void populateCB(String pathToItems, String delimiter) {
		populateCBwithString(TextFileReader.read(pathToItems, delimiter));
	}
	
	@SuppressWarnings("unchecked")
	private void populateCBwithString(Collection<String> list) {
		cbox.getItems().clear();
		list.stream().forEach(a -> cbox.getItems().add((T) a));
	}

	public void populateCB(Collection<T> list) {
		cbox.getItems().clear();
		list.stream().forEach(a -> cbox.getItems().add(a));
	}

	public T getValue() {
		return this.cbox.getValue();
	}
	
}
