package capitaly.fields;
import capitaly.players.IPlayer;

public class Service extends Field {

  public Service(Integer value) {
    super(value);
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) {
    player.removeMoney(value);
  }

}