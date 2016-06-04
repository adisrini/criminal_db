package gui.utils;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 * A custom text to display nicely on the black backgrounds.
 * 
 * @author adityasrinivasan
 *
 */
public class CustomText extends Text {
	
	private static final String DEFAULT_COLOR = "white";

	public CustomText(String text) {
		this.setText(text);
		this.setFill(Paint.valueOf(DEFAULT_COLOR));
	}

}
