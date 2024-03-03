package capitaly.players;

import capitaly.exceptions.NotEnoughMoneyException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.fields.IField;
import capitaly.fields.IProperty;

/**
 * Represents the Greedy player in the game.
 * The greedy player buys or upgrades the property, whenever it is possible.
 */
public class Greedy extends Player {

  /**
   * Instantiates a Greedy player object.
   * @param name name of the player.
   * @param currentField starting field.
   */
  public Greedy(String name, IField currentField) {
    super(name, currentField);
  }

  @Override
  public void strategy() throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException, PropertyIsNotOwnedByPlayerException {
    if(currentField instanceof IProperty property)
    {
      if(!property.hasOwner() && property.getPropertyValue() < money)
      {
        buy(property);
      }
      else if(properties.contains(property) && property.getHouseValue() < money && property.canUpgrade())
      {
        upgrade(property);
      }
    }
  }

}