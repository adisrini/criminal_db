package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import model.command.Command;
import util.DBException;

/**
 * This class uses reflection in order to provide functionality to GUI buttons.
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
