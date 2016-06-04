package gui.tab.connection.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;
import model.CrimeRecord;

public class FirstCrimeCB extends DBComboBox<CrimeRecord> implements DBNode {

	public FirstCrimeCB() {
		super("First Crime");
	}

	@Override
	public String read() {
		return "first%" + cbox.getValue();
	}

}
