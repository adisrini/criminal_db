package gui.tab.query.nodes;

import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.CrimeRecord;

/**
 * A circle representing a particular crime. Upon hover, more detail is provided about the crime.
 * 
 * @author adityasrinivasan
 *
 */
public class CrimeCircle extends Circle {
	
	/**
	 * Constants
	 */
	private static final String STROKE_COLOR = "transparent";
	private static final String BEHAVIOR_FIELD = "BEHAVIOR";
	private static final String TIMER_FIELD = "activationTimer";
	
	private Tooltip tip;
	private long recordNumber;
	
	public CrimeCircle(long num, double rad) {
		super(rad);
		this.recordNumber = num;
		RandomColor rc = new RandomColor();
		this.setFill(Paint.valueOf(rc.getRandomColor()));
		this.setStroke(Paint.valueOf(STROKE_COLOR));
	}

	/**
	 * Establishes the record's tooltip.
	 * @param record
	 */
	public void establishRecord(CrimeRecord record) {
		tip = new Tooltip(record.toString());
		hackTooltipStartTiming(tip, 10);
		Tooltip.install(this, tip);
	}
	
	/**
	 * Returns this crime's record number
	 * @return the record number
	 */
	public long getRecordNumber() {
		return this.recordNumber;
	}
	
	/**
	 * Extracted from StackOverflow. This uses reflection in order to access the Tooltip class and
	 * change the delay of appearance, so that it can be sped up or slowed down if desired.
	 * @param tooltip: the tooltip to access
	 * @param delay: the amount of delay in milliseconds
	 */
	private void hackTooltipStartTiming(Tooltip tooltip, double delay) {
	    try {
	        Field fieldBehavior = tooltip.getClass().getDeclaredField(BEHAVIOR_FIELD);
	        fieldBehavior.setAccessible(true);
	        Object objBehavior = fieldBehavior.get(tooltip);

	        Field fieldTimer = objBehavior.getClass().getDeclaredField(TIMER_FIELD);
	        fieldTimer.setAccessible(true);
	        Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

	        objTimer.getKeyFrames().clear();
	        objTimer.getKeyFrames().add(new KeyFrame(new Duration(delay)));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
