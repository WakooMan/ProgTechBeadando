package capitaly.players;

import Integer;
import void;
import Boolean;

public interface IPlayer {

  public void step();

  public void payTo(IPlayer player, Integer amount);

  public void addMoney(Integer amount);

  public void removeMoney(Integer amount);

  public Boolean isInGame();

}