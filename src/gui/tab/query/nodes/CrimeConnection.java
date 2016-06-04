package gui.tab.query.nodes;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class CrimeConnection extends Line {
	
	public CrimeConnection(double startx, double starty, double endx, double endy) {
		super(startx, starty, endx, endy);
		super.setStroke(Paint.valueOf("white"));
		super.setStrokeWidth(5);
	}

}
