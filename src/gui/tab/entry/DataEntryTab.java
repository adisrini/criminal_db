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

/**
 * 
 * The tab allowing crimes to be entered into the database.
 * The tab is automatically populated, so this class need not be edited if further nodes need to be added.
 * 
 * @author adityasrinivasan
 *
 */
public class DataEntryTab extends AbstractTab {
	
	/**
	 * Constants
	 */
	private static final String TAB_NAME = "Data Entry";
	private static final String NODES_FILE_NAME = "data_entry_nodes.txt";
	private static final String ADD_LABEL = "Add Entry";
	private static final String ADD_ID = "AddEntry";
	private static final String DELIMITER = "\n";
	private static final String PACKAGE = "gui.tab.entry.nodes.%s";
	
	private List<DBNode> inputs;
	
	public DataEntryTab(EventHandler<ActionEvent> buttonEvent) {
		super(buttonEvent);
		this.establishTab(TAB_NAME);
	}

	/**
	 * Populates the tab with nodes.
	 */
	@Override
	protected void populate() {
		pane = new VBox();
		pane.getChildren().add(controls());
		pane.getChildren().add(GUIUtils.makeColumn(GUIUtils.makeButton(ADD_LABEL, ADD_ID, this.buttonEvent)));
	}
	
	/**
	 * Reads in a text file of class names representing nodes, and adds each to the view. This process
	 * is completely automated, so that adding new nodes requires simply creating a new class and adding
	 * its name to a text file.
	 * @return
	 */
	private VBox controls() {
		VBox column = GUIUtils.makeColumn();
		inputs = new ArrayList<>();
		TextFileReader.read(NODES_FILE_NAME, DELIMITER).stream().forEach(a -> {
			Class<?> clazz;
			try {
				clazz = Class.forName(String.format(PACKAGE, a));
				DBNode node = (DBNode) clazz.getConstructor().newInstance();
				column.getChildren().add((Node) node);
				inputs.add(node);
			} catch(Exception e) {
				throw new DBException(e.getMessage());
			}
		});
		return column;
	}

	/**
	 * Returns the inputs for this tab.
	 */
	@Override
	public Collection<?> getInputs() {
		return this.inputs;
	}

}
