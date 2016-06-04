package gui.tab.entry.nodes;

import gui.tab.DBField;
import gui.tab.DBNode;

public class EntryPerpField extends DBField implements DBNode {
	
	public EntryPerpField() {
		super("Perpetrator Name", "Enter the perpetator's name (if unknown, enter \"UNKNOWN\")");
	}
	
	@Override
	public String read() {
		return "perp_name%" + myField.getText();
	}

}
