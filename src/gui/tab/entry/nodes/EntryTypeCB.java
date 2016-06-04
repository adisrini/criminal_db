package gui.tab.entry.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;

/**
 * A combobox holding all possible offenses. The combobox is populated from a text file.
 * 
 * @author adityasrinivasan
 *
 */
public class EntryTypeCB extends DBComboBox<String> implements DBNode {
	
	/**
	 * Constants
	 */
	private static final String DELIMITER = "\n";
	private static final String LABEL = "Category of Offense";
	private static final String TXT_FILE = "crime_types.txt";
	private static final String KEY = "offense%";

	public EntryTypeCB() {
		super(LABEL, TXT_FILE, DELIMITER);
	}

	@Override
	public String read() {
		return KEY + cbox.getValue();
	}

}
