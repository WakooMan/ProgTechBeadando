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

/**
 * Abstract class, which represents a player. Implements IPlayer interface.
 */
public abstract class Player implements IPlayer {

  protected Integer money;

  protected IField currentField;

  protected List<IProperty> properties;

  private String name;

  /**
   * Protected constructor, which can be used in derived class. Instantiates the money, name and currentField attribute of the player.
   * @param name name of the player.
   * @param currentField field, where the player is instantiated.
   */
  protected Player(String name, IField currentField) {
    this.name = name;
    money = 10000;
    properties = new ArrayList<IProperty>();
    this.currentField = currentField;
  }

  /**
   * Gets the name of the player.
   * @return name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the money of the player.
   * @return money of the player.
   */
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

  /**
   * Buys the given property. Used in derives class.
   * @param property property to buy.
   * @throws PropertyAlreadyHasOwnerException thrown, if property already has an owner.
   * @throws NotEnoughMoneyException thrown, if player does not have enough money to buy the property.
   */
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

  /**
   * Upgrades the given property. Used in derived class.
   * @param property property to upgrade.
   * @throws PropertyIsNotOwnedByPlayerException thrown if property is not owned by the player.
   * @throws NotEnoughMoneyException thrown if player does not have enough money to upgrade the property.
   */
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
  
  /**
   * Strategy for the player, which is implemented in derived class.
   * It is called in step method.
   * @throws PropertyAlreadyHasOwnerException thrown, if property already has an owner, but player attempts to buy it.
   * @throws NotEnoughMoneyException thrown if player does not have enough money to upgrade or buy the property, but attempts the action.
   * @throws PropertyIsNotOwnedByPlayerException thrown if property is not owned by the player, but the player attempts to upgrade it.
   */
  protected abstract void strategy() throws PropertyAlreadyHasOwnerException, NotEnoughMoneyException, PropertyIsNotOwnedByPlayerException;

  /**
   * Player throws with the dice and returns it back.
   * @return the thrown value.
   * @throws NotEnoughTestRandomNumberException thrown, if not enough random test number is available.
   */
  private Integer throwDice() throws NotEnoughTestRandomNumberException {
    Integer value = Game.getInstance().getRandomGenerator().generate();
    return value;
  }

}