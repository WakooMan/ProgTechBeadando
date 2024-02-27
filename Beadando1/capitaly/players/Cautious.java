package capitaly.players;

import capitaly.exceptions.NotEnoughMoneyException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;
import capitaly.fields.IField;
import capitaly.fields.Property;

public class Cautious extends Player {

  public Cautious(String name, IField currentField) {
    super(name, currentField);
  }

  @Override
  public void strategy() throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException, PropertyIsNotOwnedByPlayerException {
    if(currentField instanceof Property property)
    {
      if(!property.hasOwner() && property.getPropertyValue() <= money/2)
      {
        buy(property);
      }
      else if(properties.contains(property) && property.getHouseValue() <= money/2)
      {
        upgrade(property);
      }
    }
  }

}