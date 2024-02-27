package capitaly.exceptions;

public class PlayerNotInGameException extends Exception {

  public PlayerNotInGameException() {
    super();
  }

  public PlayerNotInGameException(String message) {
    super(message);
  }

}