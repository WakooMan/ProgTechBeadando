package capitaly.players;

import capitaly.exceptions.NotEnoughMoneyException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.fields.IField;
import capitaly.fields.IProperty;

/**
 * Represents the Cautious player in the game.
 * The cautious player buys or upgrades the property, if the buying value does not exceed half of the player's money.
 */
public class Cautious extends Player {

  /**
   * Instantiates a Cautious player object.
   * @param name name of the player.
   * @param currentField starting field.
   */
  public Cautious(String name, IField currentField) {
    super(name, currentField);
  }

  @Override
  public void strategy() throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException, PropertyIsNotOwnedByPlayerException {
    if(currentField instanceof IProperty property)
    {
      if(!property.hasOwner() && property.getPropertyValue() <= money/2)
      {
        buy(property);
      }
      else if(properties.contains(property) && property.getHouseValue() <= money/2 && property.canUpgrade())
      {
        upgrade(property);
      }
    }
  }

}