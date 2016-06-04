package gui.tab.entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gui.tab.AbstractTab;
import gui.tab.DBNode;
import gui.utils.GUIUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import util.DBException;
import util.TextFileReader;

public class DataEntryTab extends AbstractTab {
	
	private static final String TAB_NAME = "Data Entry";
	private static final String NODES_FILE_NAME = "data_entry_nodes.txt";
	
	private List<DBNode> inputs;
	
	public DataEntryTab(EventHandler<ActionEvent> buttonEvent) {
		super(buttonEvent);
		this.establishTab(TAB_NAME);
	}

	@Override
	protected void populate() {
		pane = new VBox();
		pane.getChildren().add(controls());
		pane.getChildren().add(GUIUtils.makeColumn(GUIUtils.makeButton("Add Entry", "AddEntry", this.buttonEvent)));
	}
	
	private VBox controls() {
		VBox column = GUIUtils.makeColumn();
		inputs = new ArrayList<>();
		TextFileReader.read(NODES_FILE_NAME, "\n").stream().forEach(a -> {
			Class<?> clazz;
			try {
				clazz = Class.forName(String.format("gui.tab.entry.nodes.%s", a));
				DBNode node = (DBNode) clazz.getConstructor().newInstance();
				column.getChildren().add((Node) node);
				inputs.add(node);
			} catch(Exception e) {
				throw new DBException(e.getMessage());
			}
		});
		return column;
	}

	@Override
	public Collection<?> getInputs() {
		return this.inputs;
	}

}
