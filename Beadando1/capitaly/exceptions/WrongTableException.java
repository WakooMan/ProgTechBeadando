package capitaly.exceptions;

public class WrongTableException extends Exception{

  public WrongTableException() {
    super();
  }

  public WrongTableException(String message) {
    super(message);
  }

}