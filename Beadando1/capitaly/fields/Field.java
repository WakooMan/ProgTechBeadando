package capitaly.fields;

import Integer;
import void;
import capitaly.players.IPlayer;

public abstract class Field implements IField {

  private IField next;

  protected Integer value;

  private Integer id;

  private static Integer createdFields;

  protected Field(Integer value) {
  }

  public Integer getId() {
  return null;
  }

  public IField getNext() {
  return null;
  }

  public void setNext(IField next) {
  }

  public abstract void onSteppedByPlayer(IPlayer player);

}