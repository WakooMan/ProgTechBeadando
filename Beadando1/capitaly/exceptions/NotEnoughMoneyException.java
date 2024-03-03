package capitaly.exceptions;

/**
 * NotEnoughMoneyException, which derives from Exception class.
 */
public class NotEnoughMoneyException extends Exception {

  /**
   * Default constructor for NotEnoughMoneyException
   */
  public NotEnoughMoneyException() {
    super();
  }

  /**
   * Constructor for NotEnoughMoneyException, which takes a message as argument.
   * @param message message
   */
  public NotEnoughMoneyException(String message) {
    super(message);
  }

}