package capitaly.fields;
import capitaly.players.IPlayer;

public interface IField {

  public Integer getId();

  public IField getNext();

  public void setNext(IField next);

  public void onSteppedByPlayer(IPlayer player);

}