package gui.tab.entry.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;

/**
 * A combobox holding all possible locations (states) for the crime to have occurred. The combobox is populated from
 * a text file.
 * 
 * @author adityasrinivasan
 *
 */
public class EntryLocationCB extends DBComboBox<String> implements DBNode {
	
	/**
	 * Constants
	 */
	private static final String DELIMITER = "\n";
	private static final String LABEL = "Location";
	private static final String TXT_FILE = "locations.txt";
	private static final String KEY = "location%";

	public EntryLocationCB() {
		super(LABEL, TXT_FILE, DELIMITER);
	}

	@Override
	public String read() {
		return KEY + cbox.getValue();
	}

}
