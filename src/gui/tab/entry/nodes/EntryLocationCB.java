package gui.tab.entry.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;

public class EntryLocationCB extends DBComboBox<String> implements DBNode {
	
	private static final String DELIMITER = "\n";

	public EntryLocationCB() {
		super("Location", "locations.txt", DELIMITER);
	}

	@Override
	public String read() {
		return "location%" + cbox.getValue();
	}

}
