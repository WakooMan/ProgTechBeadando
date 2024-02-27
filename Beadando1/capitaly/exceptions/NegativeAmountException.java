package capitaly.exceptions;

public class NegativeAmountException extends Exception {

  public NegativeAmountException() {
    super();
  }

  public NegativeAmountException(String message) {
    super(message);
  }

}