package capitaly.players;

import capitaly.fields.IProperty;
import capitaly.fields.IField;

import java.util.ArrayList;
import java.util.List;

import capitaly.Game;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.NotEnoughMoneyException;
import capitaly.exceptions.NotEnoughTestRandomNumberException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.exceptions.PropertyAlreadyHasOwnerException;
import capitaly.exceptions.PropertyIsNotOwnedByPlayerException;

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
  public void step() throws PlayerNotInGameException, NotEnoughTestRandomNumberException {
    if(!isInGame())
    {
      throw new PlayerNotInGameException("The player is not in the game!");
    }
    Integer value = throwDice();
    for(int i=0; i < value; i++)
    {
      currentField = currentField.getNext();
    }
    try{
      currentField.onSteppedByPlayer(this);
      strategy();
    }
    catch(Exception ex)
    {
      System.out.println("At" + getName() + "Player's step: " + ex.getMessage());      
    }
  }

  @Override
  public void payTo(IPlayer player, Integer amount) throws PlayerNotInGameException, NegativeAmountException{
    if(!isInGame())
    {
      throw new PlayerNotInGameException("The player is not in the game!");
    }
    removeMoney(amount);
    player.addMoney(amount);
  }

  @Override
  public void addMoney(Integer amount) throws PlayerNotInGameException, NegativeAmountException {
    if(!isInGame())
    {
      throw new PlayerNotInGameException("The player is not in the game!");
    }
    if(amount <= 0)
    {
      throw new NegativeAmountException("Cannot add a negative amount of money.");
    }

    money += amount;
  }

  @Override
  public void removeMoney(Integer amount) throws PlayerNotInGameException, NegativeAmountException {
    if(!isInGame())
    {
      throw new PlayerNotInGameException("The player is not in the game!");
    }
    if(amount <= 0)
    {
      throw new NegativeAmountException("Cannot remove a negative amount of money.");
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

  protected void buy(IProperty property) throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException {
    if(property.hasOwner())
    {
      throw new PropertyAlreadyHasOwnerException("Cannot buy the property, because it already has an owner.");
    }
    if(money <= property.getPropertyValue())
    {
      throw new NotEnoughMoneyException("Cannot buy the property, because the player does not have money for it.");
    }

    try{
      property.onBoughtByPlayer(this);
      properties.add(property);
    }
    catch(Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }

  protected void upgrade(IProperty property) throws PropertyIsNotOwnedByPlayerException, NotEnoughMoneyException {
    if(!properties.contains(property))
    {
      throw new PropertyIsNotOwnedByPlayerException("Cannot upgrade the property, because it is not the player's property.");
    }
    if(money <= property.getHouseValue())
    {
      throw new NotEnoughMoneyException("Cannot upgrade the property, because the player does not have money for it.");
    }
    try{
      property.onUpgradedByPlayer(this);
    }
    catch(Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }
  
  protected abstract void strategy() throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException, PropertyIsNotOwnedByPlayerException;

  private Integer throwDice() throws NotEnoughTestRandomNumberException {
    Integer value = Game.getInstance().getRandomGenerator().generate();
    return value;
  }

}