package capitaly.exceptions;

/**
 * PropertyIsNotOwnedException, which derives from Exception class.
 */
public class PropertyIsNotOwnedException extends Exception {

  /**
   * Default constructor for PropertyIsNotOwnedException
   */
  public PropertyIsNotOwnedException() {
    super();
  }

  /**
   * Constructor for PropertyIsNotOwnedException, which takes a message as argument.
   * @param message message
   */
  public PropertyIsNotOwnedException(String message) {
    super(message);
  }

}