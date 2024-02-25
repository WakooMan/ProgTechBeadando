package capitaly.players;

import capitaly.fields.IField;
import capitaly.fields.Property;

public class Greedy extends Player {

  public Greedy(String name, IField currentField) {
    super(name, currentField);
  }

  @Override
  public void strategy() {
    if(currentField instanceof Property property)
    {
      if(!property.hasOwner() && property.getPropertyValue() <= money)
      {
        buy(property);
      }
      else if(properties.contains(property) && property.getHouseValue() <= money)
      {
        upgrade(property);
      }
    }
  }

}