package capitaly.exceptions;

public class PropertyIsNotOwnedByPlayerException extends Exception {

  public PropertyIsNotOwnedByPlayerException() {
    super();
  }

  public PropertyIsNotOwnedByPlayerException(String message) {
    super(message);
  }

}