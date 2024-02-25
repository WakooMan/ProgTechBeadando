package capitaly.players;

import capitaly.fields.IField;
import capitaly.fields.Property;

public class Tactician extends Player {

  private Integer buyingChance;

  public Tactician(String name, IField currentField) {
    super(name, currentField);
    buyingChance = 0;
  }

  @Override
  public void strategy() {
    if(currentField instanceof Property property)
    {
      if(!property.hasOwner() && property.getPropertyValue() <= money)
      {
        if(buyingChance % 2 == 0)
        {
          buy(property);
        }
        buyingChance++;
      }
      else if(properties.contains(property) && property.getHouseValue() <= money)
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