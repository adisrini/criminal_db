package gui.tab.entry.nodes;

import gui.tab.DBField;
import gui.tab.DBNode;

/**
 * A text field for entering the victim's name.
 * 
 * @author adityasrinivasan
 *
 */
public class EntryVictimField extends DBField implements DBNode {
	
	/**
	 * Constants
	 */
	private static final String LABEL = "Victim's Name";
	private static final String PROMPT = "Enter the victim's name (if unknown, enter \"UNKNOWN\")";
	private static final String KEY = "victim_name%";
	
	public EntryVictimField() {
		super(LABEL, PROMPT);
	}
	
	@Override
	public String read() {
		return KEY + myField.getText();
	}

}
