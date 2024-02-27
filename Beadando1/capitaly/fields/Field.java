package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.players.IPlayer;

public abstract class Field implements IField {

  private IField next;

  protected Integer value;
  
  private Integer id;

  private static Integer createdFields = 0;

  protected Field(Integer value) {
    createdFields++;
    id = createdFields;
    this.next = null;
    this.value = value;
  }

  @Override
  public Integer getId()
  {
    return id;
  }

  @Override
  public IField getNext() {
    return next;
  }

  @Override
  public void setNext(IField next) {
    this.next = next;
  }

  @Override
  public abstract void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException;

}