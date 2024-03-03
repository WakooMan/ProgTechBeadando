package capitaly.exceptions;

/**
 * PropertyIsNotOwnedByPlayerException, which derives from Exception class.
 */
public class PropertyIsNotOwnedByPlayerException extends Exception {

  /**
   * Default constructor for PropertyIsNotOwnedByPlayerException
   */
  public PropertyIsNotOwnedByPlayerException() {
    super();
  }

  /**
   * Constructor for PropertyIsNotOwnedByPlayerException, which takes a message as argument.
   * @param message message
   */
  public PropertyIsNotOwnedByPlayerException(String message) {
    super(message);
  }

}