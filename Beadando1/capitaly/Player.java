package capitaly;

import Integer;
import void;
import capitaly.fields.IProperty;
import String;
import capitaly.fields.IField;
import Boolean;
import capitaly.players.IPlayer;
import List<IProperty>;

public abstract class Player implements IPlayer {

  protected Integer money;

  protected IField currentField;

  protected List<IProperty> properties;

  private String name;

  protected Player(String name, IField currentField) {
  }

  public String getName() {
  return null;
  }

  public Integer getMoney() {
  return null;
  }

  public void step() {
  }

  public void payTo(IPlayer player, Integer amount) {
  }

  public void addMoney(Integer amount) {
  }

  public void removeMoney(Integer amount) {
  }

  public Boolean isInGame() {
  return null;
  }

  public String toString() {
  return null;
  }

  protected void buy(IProperty property) {
  }

  protected void upgrade(IProperty property) {
  }

  protected abstract void strategy();

  private Integer throwDice() {
  return null;
  }

}