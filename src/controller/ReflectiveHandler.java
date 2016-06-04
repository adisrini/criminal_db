package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import model.command.Command;
import util.DBException;

/**
 * This class uses reflection in order to provide functionality to GUI buttons. The buttons are provided with
 * IDs, and passed here by the controller. Reflection is used to instantiate the command that matches the
 * command specified by the button's ID. This maintains extensibility and flexibility, since adding functionality
 * to buttons requires creation of new classes as opposed to editing existing files.
 * 
 * @author adityasrinivasan
 *
 */
public class ReflectiveHandler {
	
	/**
	 * Constants
	 */
	private static final String PACKAGE = "model.command.%sCommand";
	
	static void handle(String ID, Collection<?> inputs) {
		try {
			Class<?> clazz = Class.forName(String.format(PACKAGE, ID));
			Command command = (Command) clazz.getConstructor(Collection.class).newInstance(inputs);
			command.execute();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new DBException(e.getMessage());
		}
	}

}
