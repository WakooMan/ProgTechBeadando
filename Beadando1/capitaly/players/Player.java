package capitaly.players;

import capitaly.fields.IProperty;
import capitaly.fields.IField;

import java.util.ArrayList;
import java.util.List;

import capitaly.Game;

public abstract class Player implements IPlayer {

  protected Integer money;

  protected IField currentField;

  protected List<IProperty> properties;

  private String name;

  protected Player(String name, IField currentField) {
    this.name = name;
    money = 10000;
    properties = new ArrayList<IProperty>();
    this.currentField = currentField;
  }

  public String getName() {
    return name;
  }

  public Integer getMoney() {
    return money;
  }

  @Override
  public void step() {
    if(!isInGame())
    {
      throw new IllegalStateException("The player is not in the game!");
    }
    Integer value = throwDice();
    for(int i=0; i < value; i++)
    {
      currentField = currentField.getNext();
    }
    currentField.onSteppedByPlayer(this);
    strategy();
  }

  @Override
  public void payTo(IPlayer player, Integer amount) {
    if(!isInGame())
    {
      throw new IllegalStateException("The player is not in the game!");
    }
    removeMoney(amount);
    player.addMoney(amount);
  }

  @Override
  public void addMoney(Integer amount) {
    if(!isInGame())
    {
      throw new IllegalStateException("The player is not in the game!");
    }
    if(amount <= 0)
    {
      throw new IllegalArgumentException("Cannot add a negative amount of money.");
    }

    money += amount;
  }

  @Override
  public void removeMoney(Integer amount) {
    if(!isInGame())
    {
      throw new IllegalStateException("The player is not in the game!");
    }
    if(amount <= 0)
    {
      throw new IllegalArgumentException("Cannot remove a negative amount of money.");
    }

    money -= amount;

    if(money <= 0)
    {
      currentField = null;
      for(IProperty property : properties)
      {
        property.onOwnerPlayerLost();
      }
      properties.clear();
      properties = null;
    }
  }

  @Override
  public Boolean isInGame() {
    return currentField != null;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + getName() + System.lineSeparator());
    sb.append("IsInGame: " + isInGame() + System.lineSeparator());
    sb.append("Money: " + getMoney() + System.lineSeparator());
    sb.append("CurrentField: " + ((currentField != null)? currentField.getId() : "null") + System.lineSeparator());
    sb.append("Properties:" + System.lineSeparator());
    if(isInGame())
    {
      for(IProperty property : properties)
      {
        sb.append(property + System.lineSeparator());
      }
    }
    return sb.toString();
  }

  protected void buy(IProperty property) {
    if(property.hasOwner())
    {
      throw new IllegalStateException("Cannot buy the property, because it already has an owner.");
    }
    if(money < property.getPropertyValue())
    {
      throw new IllegalStateException("Cannot buy the property, because the player does not have money for it.");
    }
    property.onBoughtByPlayer(this);
    properties.add(property);
  }

  protected void upgrade(IProperty property) {
    if(!properties.contains(property))
    {
      throw new IllegalStateException("Cannot upgrade the property, because it is not the player's property.");
    }
    if(money < property.getHouseValue())
    {
      throw new IllegalStateException("Cannot upgrade the property, because the player does not have money for it.");
    }
    property.onUpgradedByPlayer(this);
  }
  
  protected abstract void strategy();

  private Integer throwDice() {
    Integer value = Game.getInstance().getRandomGenerator().generate();
    System.out.println(getName() + "thrown: " + value);
    return value;
  }

}