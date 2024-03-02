package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.exceptions.PropertyIsNotOwnedException;
import capitaly.players.IPlayer;

public class Property extends Field implements IProperty {

  private IPlayer owner;

  public Property() {
    super(0);
    owner = null;
    value = 0;
  }

  @Override
  public void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException {
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
  public Boolean canUpgrade() {
    return hasOwner() && 4000 > value;
  }

  @Override
  public void onBoughtByPlayer(IPlayer player) throws PropertyAlreadyHasOwnerException, PlayerNotInGameException, NegativeAmountException {
    if(owner != null)
    {
      throw new PropertyAlreadyHasOwnerException("The player cannot buy the property, because the property is already bought.");
    }
    player.removeMoney(getPropertyValue());
    owner = player;
    value = 1000;
  }

  @Override
  public void onUpgradedByPlayer(IPlayer player) throws PropertyIsNotOwnedException, PropertyIsNotOwnedByPlayerException, PlayerNotInGameException, NegativeAmountException {
    if(owner == null)
    {
      throw new PropertyIsNotOwnedException("The player cannot upgrade the property, because the property is not bought yet.");
    }
    if(owner != player)
    {
      throw new PropertyIsNotOwnedByPlayerException("The player cannot upgrade the property, because the player is not the owner.");
    }
    player.removeMoney(getHouseValue());
    value = 4000;

  }

  @Override
  public Integer getPropertyValue() {
    return 500;
  }

  @Override
  public Integer getHouseValue() {
    return 2000;
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
    sb.append("\tHasHouse: " + (value == 4000) + System.lineSeparator());
    sb.append("\tValue: " + value + System.lineSeparator());
    return sb.toString();
  }

}