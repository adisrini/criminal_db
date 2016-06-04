package gui.tab.connection.nodes;

import gui.tab.DBComboBox;
import gui.tab.DBNode;
import model.CrimeRecord;

public class SecondCrimeCB extends DBComboBox<CrimeRecord> implements DBNode {

	public SecondCrimeCB() {
		super("Second Crime");
	}

	@Override
	public String read() {
		return "second%" + cbox.getValue();
	}

}
