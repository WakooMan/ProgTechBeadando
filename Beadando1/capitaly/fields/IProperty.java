package capitaly.fields;

import Integer;
import void;
import Boolean;
import capitaly.players.IPlayer;

public interface IProperty {

  public void onBoughtByPlayer(IPlayer player);

  public void onOwnerPlayerLost();

  public Boolean hasOwner();

  public Integer getPropertyValue();

  public Integer getHouseValue();

  public void onUpgradedByPlayer(IPlayer player);

}