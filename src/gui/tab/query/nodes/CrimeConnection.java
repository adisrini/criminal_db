package gui.tab.query.nodes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 * A custom line intended to serve as a connection between two crimes.
 * 
 * @author adityasrinivasan
 *
 */
public class CrimeConnection extends Line {
	
	private static final String STROKE_COLOR = "white";
	private static final double WIDTH = 5;
	
	public CrimeConnection(double startx, double starty, double endx, double endy) {
		super(startx, starty, endx, endy);
		super.setStroke(Paint.valueOf(STROKE_COLOR));
		super.setStrokeWidth(WIDTH);
	}

}
