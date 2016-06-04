package gui.tab.connection.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;
import model.CrimeRecord;

/**
 * A combobox holding records of crimes entered into the database.
 * 
 * @author adityasrinivasan
 *
 */
public class FirstCrimeCB extends DBComboBox<CrimeRecord> implements DBNode {

	private static final String LABEL = "First Crime";
	private static final String KEY = "first%";
	
	public FirstCrimeCB() {
		super(LABEL);
	}

	@Override
	public String read() {
		return KEY + cbox.getValue();
	}

}
