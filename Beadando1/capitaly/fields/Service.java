package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.players.IPlayer;

/**
 * Service class, which is a Field. When a player steps on it, some amount of money is taken from the player.
 */
public class Service extends Field {

  /**
   * Public constructor for Service object instantiation.
   * @param value value of the field.
   */
  public Service(Integer value) {
    super(value);
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException {
    player.removeMoney(value);
  }

}