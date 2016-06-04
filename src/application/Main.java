package application;

import controller.DBController;
import controller.IController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the entry point to the application. It is mostly boilerplate code in order to initialize
 * the GUI and controller.
 * 
 * @author adityasrinivasan
 *
 */
public class Main extends Application {

	/**
	 * Constants
	 */
	private static final String STYLESHEET_PATH = "/application/application.css";

	@Override
	public void start(Stage primaryStage) throws Exception {
		IController controller = new DBController();
		Scene scene = new Scene(controller.getGUI());
		scene.getStylesheets().add(STYLESHEET_PATH);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setMaximized(true);
	}

	public static void main(String args[]) {
		launch(args);
	}
	
}
