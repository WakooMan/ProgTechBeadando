package capitaly.fields;

import Integer;
import void;
import capitaly.players.IPlayer;

public interface IField {

  public Integer getId();

  public IField getNext();

  public void setNext(IField next);

  public void onSteppedByPlayer(IPlayer player);

}