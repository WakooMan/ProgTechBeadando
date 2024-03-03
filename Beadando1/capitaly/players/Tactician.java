package capitaly.players;

import capitaly.exceptions.NotEnoughMoneyException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.fields.IField;
import capitaly.fields.IProperty;

/**
 * Represents the Tactician player in the game.
 * The tactician player buys or upgrades the property in every second buying chance.
 */
public class Tactician extends Player {

  private Integer buyingChance;

  /**
   * Instantiates a Tactician player object.
   * @param name name of the player.
   * @param currentField starting field.
   */
  public Tactician(String name, IField currentField) {
    super(name, currentField);
    buyingChance = 0;
  }

  @Override
  public void strategy() throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException, PropertyIsNotOwnedByPlayerException {
    if(currentField instanceof IProperty property)
    {
      if(!property.hasOwner() && property.getPropertyValue() < money)
      {
        if(buyingChance % 2 == 0)
        {
          buy(property);
        }
        buyingChance++;
      }
      else if(properties.contains(property) && property.getHouseValue() < money && property.canUpgrade())
      {
        if(buyingChance % 2 == 0)
        {
          upgrade(property);
        }
        buyingChance++;
      }
    }
  }

}