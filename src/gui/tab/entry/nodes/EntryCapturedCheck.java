package gui.tab.entry.nodes;

import gui.tab.DBCheckBox;
import gui.tab.DBNode;

public class EntryCapturedCheck extends DBCheckBox implements DBNode {

	public EntryCapturedCheck() {
		super("Captured?");
	}

	@Override
	public String read() {
		return "captured%" + Boolean.toString(xbox.isSelected());
	}

}
