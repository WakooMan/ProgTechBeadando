package capitaly.fields;
import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.PlayerNotInGameException;
import capitaly.players.IPlayer;

/**
 * A public interface, which represents a field's behaviour.
 */
public interface IField {

  /**
   * Gets the Id of the field. 
   * @return Id of the field.
   */
  public Integer getId();

  /**
   * Gets the next field on the table.
   * @return Next field.
   */
  public IField getNext();

  /**
   * Sets the next field on the table for an IField object.
   * @param next IField object, which is going to set as next field.
   */
  public void setNext(IField next);

  /**
   * This is a method, which is called, when a player steps on the field object.
   * @param player Player, who stepped on the field.
   * @throws PlayerNotInGameException If player is not in the game anymore, then this exception is thrown.
   * @throws NegativeAmountException If negative amount of money is taken/added from/to the player, then this exception is thrown.
   */
  public void onSteppedByPlayer(IPlayer player) throws PlayerNotInGameException, NegativeAmountException;

}