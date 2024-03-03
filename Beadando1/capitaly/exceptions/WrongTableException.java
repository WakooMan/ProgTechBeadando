package capitaly.exceptions;

/**
 * WrongTableException, which derives from Exception class.
 */
public class WrongTableException extends Exception{

  /**
   * Default constructor for WrongTableException
   */
  public WrongTableException() {
    super();
  }

  /**
   * Constructor for WrongTableException, which takes a message as argument.
   * @param message message
   */
  public WrongTableException(String message) {
    super(message);
  }

}