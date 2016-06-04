package gui.tab;

import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;

public abstract class AbstractTab extends Tab {
	
	protected EventHandler<ActionEvent> buttonEvent;
	protected Pane pane;
	
	public AbstractTab(EventHandler<ActionEvent> buttonEvent) {
		this.buttonEvent = buttonEvent;
		populate();
		setContent();
	}
	
	protected void establishTab(String name) {
		this.setText(name);
		this.setClosable(false);
	}
	
	protected abstract void populate();
	
	protected void setContent() {
		this.setContent(pane);
	}
	
	public abstract Collection<?> getInputs();

}
