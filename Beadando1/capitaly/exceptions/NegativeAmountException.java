package capitaly.exceptions;

/**
 * NegativeAmountException, which derives from Exception class.
 */
public class NegativeAmountException extends Exception {

  /**
   * Default constructor for NegativeAmountException
   */
  public NegativeAmountException() {
    super();
  }

  /**
   * Constructor for NegativeAmountException, which takes a message as argument.
   * @param message message
   */
  public NegativeAmountException(String message) {
    super(message);
  }

}