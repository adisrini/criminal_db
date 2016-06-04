package util;

/**
 * A custom exception class.
 * 
 * @author adityasrinivasan
 *
 */
public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DBException(String message) {
		super(message);
	}
	
	public DBException(Throwable cause) {
		super(cause);
	}
	
	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
