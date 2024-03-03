package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.players.IPlayer;

/**
 * Luck class, which is a Field. When a player steps on it, some amount of money is added to the player.
 */
public class Luck extends Field {

  /**
   * Public constructor for Luck object instantiation.
   * @param value value of the field.
   */
  public Luck(Integer value) {
    super(value);
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException {
    player.addMoney(value);
  }

}