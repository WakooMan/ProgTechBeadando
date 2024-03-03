package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.exceptions.PropertyIsNotOwnedException;
import capitaly.players.IPlayer;

/**
 * Public interface,  which represents a property's behaviour.
 */
public interface IProperty {

  /**
   * This method is called, when a player buys the property.
   * @param player Player, who bought the property.
   * @throws PropertyAlreadyHasOwnerException thrown, when property already has an owner.
   * @throws PlayerNotInGameException thrown if the player is not in the game, who buy the property.
   * @throws NegativeAmountException thrown if negative amount of money is taken from the player, when buying the property.
   */
  public void onBoughtByPlayer(IPlayer player) throws PropertyAlreadyHasOwnerException, PlayerNotInGameException, NegativeAmountException;

  /**
   * This method is called, when the owner player of the property lost the game.
   * Resets the owner to null, so other players can buy the property again.
   */
  public void onOwnerPlayerLost();

  /**
   * Returns whether a property has an owner or not.
   * @return True if property has owner, else false.
   */
  public Boolean hasOwner();

  /**
   * Returns whether a property can be upgraded or not.
   * @return True if property can be upgraded, else false.
   */
  public Boolean canUpgrade();

  /**
   * Gets the property value cost.
   * @return property value.
   */
  public Integer getPropertyValue();

  /**
   * Gets the house value cost.
   * @return house value on property.
   */
  public Integer getHouseValue();

  /**
   * This method is called, when a player upgrades the property.
   * @param player Player, who upgraded the property.
   * @throws PropertyIsNotOwnedException thrown, if property is not yet owned by anyone.
   * @throws PropertyIsNotOwnedByPlayerException thrown, if property is not owned by the player in the argument.
   * @throws PlayerNotInGameException thrown, if player is not in game.
   * @throws NegativeAmountException thrown if negative amount of money is taken from the player, when upgrading the property.
   */
  public void onUpgradedByPlayer(IPlayer player) throws PropertyIsNotOwnedException, PropertyIsNotOwnedByPlayerException, PlayerNotInGameException, NegativeAmountException;

}