package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.players.IPlayer;

public class Service extends Field {

  public Service(Integer value) {
    super(value);
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException {
    player.removeMoney(value);
  }

}