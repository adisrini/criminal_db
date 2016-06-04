package gui.tab.entry.nodes;

import gui.tab.DBCheckBox;
import gui.tab.DBNode;

/**
 * A checkbox indicating whether the suspect has been captured.
 * 
 * @author adityasrinivasan
 *
 */
public class EntryCapturedCheck extends DBCheckBox implements DBNode {

	/**
	 * Constants
	 */
	private static final String LABEL = "Captured?";
	private static final String KEY = "captured%";
	
	public EntryCapturedCheck() {
		super(LABEL);
	}

	@Override
	public String read() {
		return KEY + Boolean.toString(xbox.isSelected());
	}

}
