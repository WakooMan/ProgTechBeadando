package capitaly.fields;
import capitaly.players.IPlayer;

public class Luck extends Field {

  public Luck(Integer value) {
    super(value);
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) {
    player.addMoney(value);
  }

}