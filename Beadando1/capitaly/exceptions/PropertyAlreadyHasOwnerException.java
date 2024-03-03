package capitaly.exceptions;

/**
 * PropertyAlreadyHasOwnerException, which derives from Exception class.
 */
public class PropertyAlreadyHasOwnerException extends Exception {

  /**
   * Default constructor for PropertyAlreadyHasOwnerException
   */
  public PropertyAlreadyHasOwnerException() {
    super();
  }

  /**
   * Constructor for PropertyAlreadyHasOwnerException, which takes a message as argument.
   * @param message message
   */
  public PropertyAlreadyHasOwnerException(String message) {
    super(message);
  }

}