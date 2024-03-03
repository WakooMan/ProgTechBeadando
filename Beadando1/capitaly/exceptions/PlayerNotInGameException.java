package capitaly.exceptions;

/**
 * PlayerNotInGameException, which derives from Exception class.
 */
public class PlayerNotInGameException extends Exception {

  /**
   * Default constructor for PlayerNotInGameException
   */
  public PlayerNotInGameException() {
    super();
  }

  /**
   * Constructor for PlayerNotInGameException, which takes a message as argument.
   * @param message message
   */
  public PlayerNotInGameException(String message) {
    super(message);
  }

}