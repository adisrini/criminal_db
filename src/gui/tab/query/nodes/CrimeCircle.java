package gui.tab.query.nodes;

import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.CrimeRecord;

public class CrimeCircle extends Circle {
	
	private Tooltip tip;
	private long recordNumber;
	
	public CrimeCircle(long num, double rad) {
		super(rad);
		this.recordNumber = num;
		RandomColor rc = new RandomColor();
		this.setFill(Paint.valueOf(rc.getRandomColor()));
		this.setStroke(Paint.valueOf("transparent"));
	}

	public void establishRecord(CrimeRecord record) {
		tip = new Tooltip(record.toString());
		hackTooltipStartTiming(tip, 10);
		Tooltip.install(this, tip);
	}
	
	public long getRecordNumber() {
		return this.recordNumber;
	}
	
	// from StackOverflow, speeds up appearance of tooltip.
	private void hackTooltipStartTiming(Tooltip tooltip, double delay) {
	    try {
	        Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
	        fieldBehavior.setAccessible(true);
	        Object objBehavior = fieldBehavior.get(tooltip);

	        Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
	        fieldTimer.setAccessible(true);
	        Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

	        objTimer.getKeyFrames().clear();
	        objTimer.getKeyFrames().add(new KeyFrame(new Duration(delay)));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
