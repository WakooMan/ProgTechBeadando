package capitaly.exceptions;

/**
 * NotEnoughTestRandomNumberException, which derives from Exception class.
 */
public class NotEnoughTestRandomNumberException extends Exception {

  /**
   * Default constructor for NotEnoughTestRandomNumberException
   */
  public NotEnoughTestRandomNumberException() {
    super();
  }

  /**
   * Constructor for NotEnoughTestRandomNumberException, which takes a message as argument.
   * @param message message
   */
  public NotEnoughTestRandomNumberException(String message) {
    super(message);
  }
  
}