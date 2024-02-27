package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.exceptions.PropertyIsNotOwnedException;
import capitaly.players.IPlayer;

public interface IProperty {

  public void onBoughtByPlayer(IPlayer player) throws PropertyAlreadyHasOwnerException, PlayerNotInGameException, NegativeAmountException;

  public void onOwnerPlayerLost();

  public Boolean hasOwner();

  public Integer getPropertyValue();

  public Integer getHouseValue();

  public void onUpgradedByPlayer(IPlayer player) throws PropertyIsNotOwnedException, PropertyIsNotOwnedByPlayerException, PlayerNotInGameException, NegativeAmountException;

}