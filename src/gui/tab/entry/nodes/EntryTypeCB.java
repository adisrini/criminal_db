package gui.tab.entry.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;

public class EntryTypeCB extends DBComboBox<String> implements DBNode {
	
	private static final String DELIMITER = "\n";

	public EntryTypeCB() {
		super("Category of Offense", "crime_types.txt", DELIMITER);
	}

	@Override
	public String read() {
		return "offense%" + cbox.getValue();
	}

}
