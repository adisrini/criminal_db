package gui.tab.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cinchapi.concourse.thrift.Operator;

import gui.tab.AbstractTab;
import gui.tab.query.nodes.CrimeCircle;
import gui.tab.query.nodes.CrimeConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import model.ConcourseManager;
import model.CrimeRecord;

/**
 * 
 * The tab allowing crimes to be visualized.
 * The idea is that ConcourseDB is a Graph in an of itself, and this visualization is a fairly accurate representation
 * of how the database is structured. Moreover, a crime map is typically visualized in such a manner, and proves to be
 * useful when the number of crimes increases significantly. 
 * 
 * @author adityasrinivasan
 *
 */
public class DataExplorationTab extends AbstractTab {

	/**
	 * Constants
	 */
	private static final String LINK_KEY = "link";
	private static final String TAB_NAME = "Explore";
	private static final double CIRCLE_SIZE = 300;
	private static final double RING_SIZE = 250;
	private static final double CIRCLE_DEGREES = 360;
	
	private Group myMap;
	private List<CrimeCircle> circles;
	
	public DataExplorationTab(EventHandler<ActionEvent> buttonEvent) {
		super(buttonEvent);
		this.establishTab(TAB_NAME);
	}

	/**
	 * Initializes the panes.
	 */
	@Override
	protected void populate() {
		pane = new StackPane();
		myMap = new Group();
		pane.getChildren().add(myMap);
	}

	@Override
	public Collection<?> getInputs() {
		return null;
	}
	
	/**
	 * Populates the pane with the crime circles and connections.
	 */
	public void populateMap() {
		myMap.getChildren().clear();
		makeCircles();
		makeConnections();
	}
	
	/**
	 * Searches the database and creates a circle for each record. They are automatically sized and spaced so that
	 * they never appear too large or distant.
	 */
	private void makeCircles() {
		int i = 0;
		circles = new ArrayList<>();
		double numRecords = ConcourseManager.getInstance().getRecords().size();
		for(CrimeRecord record : ConcourseManager.getInstance().getRecords()) {
			CrimeCircle circle = new CrimeCircle(record.getRecordNumber(), CIRCLE_SIZE / numRecords);
			circle.setTranslateX(RING_SIZE * Math.cos(Math.toRadians((i - 1) * (CIRCLE_DEGREES / numRecords))));
			circle.setTranslateY(RING_SIZE * Math.sin(Math.toRadians((i - 1) * (CIRCLE_DEGREES / numRecords))));
			circle.establishRecord(record);
			circles.add(circle);
			myMap.getChildren().add(circle);
			i++;
		}
	}
	
	/**
	 * Creates the connection lines between the crimes. This is done by searching through each record in the database
	 * and every record that it is linked to, and forms the lines accordingly.
	 */
	private void makeConnections() {
		for(CrimeRecord record : ConcourseManager.getInstance().getRecords()) {
			if(!ConcourseManager.getInstance().concourse().find(LINK_KEY, Operator.LINKS_TO, record.getRecordNumber()).isEmpty()) {
				for(long recordNumber : ConcourseManager.getInstance().concourse().find(LINK_KEY, Operator.LINKS_TO, record.getRecordNumber())) {
					double startX = getCircleByRecord(recordNumber).getTranslateX();
					double startY = getCircleByRecord(recordNumber).getTranslateY();
					double endX = getCircleByRecord(record.getRecordNumber()).getTranslateX();
					double endY = getCircleByRecord(record.getRecordNumber()).getTranslateY();
					CrimeConnection connection = new CrimeConnection(startX,
																     startY,
																     endX,
																     endY);
					myMap.getChildren().add(connection);
					connection.toBack();
				}
			}
		}
	}
	
	/**
	 * Returns a circle given its record number.
	 * @param record
	 * @return
	 */
	private CrimeCircle getCircleByRecord(long record) {
		for(CrimeCircle circle : circles) {
			if(record == circle.getRecordNumber()) {
				return circle;
			}
		}
		return null;
	}
	
}
