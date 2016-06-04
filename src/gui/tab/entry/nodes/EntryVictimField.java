package gui.tab.entry.nodes;

import gui.tab.DBField;
import gui.tab.DBNode;

public class EntryVictimField extends DBField implements DBNode {
	
	public EntryVictimField() {
		super("Victim's Name", "Enter the victim's name (if unknown, enter \"UNKNOWN\")");
	}
	
	@Override
	public String read() {
		return "victim_name%" + myField.getText();
	}

}
