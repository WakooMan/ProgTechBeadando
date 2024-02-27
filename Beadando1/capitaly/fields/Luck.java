package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.players.IPlayer;

public class Luck extends Field {

  public Luck(Integer value) {
    super(value);
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException {
    player.addMoney(value);
  }

}