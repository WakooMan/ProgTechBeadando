package capitaly.fields;
import capitaly.players.IPlayer;

public class Property extends Field implements IProperty {

  private IPlayer owner;

  public Property() {
    super(0);
    owner = null;
    value = 0;
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) {
    if(owner == null || owner == player)
    {
      return;
    }

    player.removeMoney(value);
  }

  @Override
  public Boolean hasOwner() {
    return owner != null;
  }

  @Override
  public void onBoughtByPlayer(IPlayer player) {
    if(owner != null)
    {
      throw new IllegalStateException("The player cannot buy the property, because the property is already bought.");
    }
    player.removeMoney(getPropertyValue());
    owner = player;
    value = 500;
  }

  @Override
  public void onUpgradedByPlayer(IPlayer player) {
    if(owner == null)
    {
      throw new IllegalStateException("The player cannot upgrade the property, because the property is not bought yet.");
    }
    if(owner != player)
    {
      throw new IllegalStateException("The player cannot upgrade the property, because the player is not the owner.");
    }
    player.removeMoney(getHouseValue());
    value = 2000;

  }

  @Override
  public Integer getPropertyValue() {
    return 1000;
  }

  @Override
  public Integer getHouseValue() {
    return 4000;
  }

  @Override
  public void onOwnerPlayerLost() {
    owner = null;
    value = 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\tId: " + getId() + System.lineSeparator());
    sb.append("\tHasHouse: " + (value == getHouseValue()) + System.lineSeparator());
    sb.append("\tValue: " + value + System.lineSeparator());
    return sb.toString();
  }

}