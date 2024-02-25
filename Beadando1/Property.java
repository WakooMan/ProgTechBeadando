import capitaly.fields.Field;
import capitaly.fields.IProperty;
import capitaly.players.IPlayer;

public class Property extends Field implements IProperty {

  private IPlayer owner;

  public Property() {
  }

  public void onSteppedByPlayer(IPlayer player) {
  }

  public Boolean hasOwner() {
  return null;
  }

  public void onBoughtByPlayer(IPlayer player) {
  }

  public void onUpgradedByPlayer(IPlayer player) {
  }

  public Integer getPropertyValue() {
  return null;
  }

  public Integer getHouseValue() {
  return null;
  }

  public void onOwnerPlayerLost() {
  }

  public String toString() {
  return null;
  }

}