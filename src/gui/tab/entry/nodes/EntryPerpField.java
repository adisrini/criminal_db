package gui.tab.entry.nodes;

import gui.tab.DBField;
import gui.tab.DBNode;

/**
 * A text field for entering the perpetrator's name.
 * 
 * @author adityasrinivasan
 *
 */
public class EntryPerpField extends DBField implements DBNode {
	
	/**
	 * Constants
	 */
	private static final String LABEL = "Perpetrator Name";
	private static final String PROMPT = "Enter the perpetator's name (if unknown, enter \"UNKNOWN\")";
	private static final String KEY = "perp_name%";
	
	public EntryPerpField() {
		super(LABEL, PROMPT);
	}
	
	@Override
	public String read() {
		return KEY + myField.getText();
	}

}
