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

public class DataExplorationTab extends AbstractTab {

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

	public void populateMap() {
		myMap.getChildren().clear();
		makeCircles();
		makeConnections();
	}
	
	private void makeCircles() {
		int i = 0;
		circles = new ArrayList<>();
		double numRecords = ConcourseManager.getInstance().getRecords().size();
		for(CrimeRecord record : ConcourseManager.getInstance().getRecords()) {
			CrimeCircle circle = new CrimeCircle(record.getRecordNumber(), CIRCLE_SIZE / numRecords);
			circle.setTranslateX(RING_SIZE * Math.cos(Math.toRadians((i - 1) * (CIRCLE_DEGREES / numRecords))));
			circle.setTranslateY(RING_SIZE * Math.sin(Math.toRadians((i - 1) * (CIRCLE_DEGREES / numRecords))));
			System.out.println(record.getPerpetrator() + " " + circle.getTranslateX() + " " + circle.getTranslateY());
			circle.establishRecord(record);
			circles.add(circle);
			myMap.getChildren().add(circle);
			i++;
		}
	}
	
	private void makeConnections() {
		double numRecords = ConcourseManager.getInstance().getRecords().size();
		double offset = CIRCLE_SIZE / numRecords;
		for(CrimeRecord record : ConcourseManager.getInstance().getRecords()) {
			if(!ConcourseManager.getInstance().concourse().find("link", Operator.LINKS_TO, record.getRecordNumber()).isEmpty()) {
				for(long recordNumber : ConcourseManager.getInstance().concourse().find("link", Operator.LINKS_TO, record.getRecordNumber())) {
					double startX = getCircleByRecord(recordNumber).getTranslateX();
					double startY = getCircleByRecord(recordNumber).getTranslateY();
					double endX = getCircleByRecord(record.getRecordNumber()).getTranslateX();
					double endY = getCircleByRecord(record.getRecordNumber()).getTranslateY();
					System.out.println("STARTING CIRCLE: " + getCircleByRecord(recordNumber).getRecordNumber() + " " + startX + " " + startY);
					System.out.println("ENDING CIRCLE: " + record.getRecordNumber() + " " + endX + " " + endY);
					System.out.println("OFFSET: " + offset);
					CrimeConnection connection = new CrimeConnection(startX,
																     startY,
																     endX,
																     endY);
					System.out.println(connection.getStartX() + " " + connection.getStartY() + " " + connection.getEndX() + " " + connection.getEndY());
					myMap.getChildren().add(connection);
					connection.toBack();
				}
			}
		}
	}
	
	private CrimeCircle getCircleByRecord(long record) {
		for(CrimeCircle circle : circles) {
			if(record == circle.getRecordNumber()) {
				return circle;
			}
		}
		return null;
	}
	
}
