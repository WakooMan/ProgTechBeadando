package capitaly.players;

import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.NotEnoughTestRandomNumberException;
import capitaly.exceptions.PlayerNotInGameException;

/**
 * Public interface, which represents a player's behaviour.
 */
public interface IPlayer {

  /**
   * The player steps. Throws with a dice and does it's job according to it's player type.
   * @throws PlayerNotInGameException thrown if the player, who steps is not in the game.
   * @throws NotEnoughTestRandomNumberException thrown if there is not enough random test number to end the game.
   */
  public void step() throws PlayerNotInGameException, NotEnoughTestRandomNumberException;

  /**
   * The player pays to another player the given amount of money.
   * @param player player to pay to.
   * @param amount amount of money.
   * @throws PlayerNotInGameException thrown if the player, who pays is not in the game.
   * @throws NegativeAmountException thrown if amount is negative.
   */
  public void payTo(IPlayer player, Integer amount) throws PlayerNotInGameException, NegativeAmountException;

  /**
   * Adds a given amount of money to the player.
   * @param amount amount of money.
   * @throws PlayerNotInGameException thrown if the player, who is not in the game.
   * @throws NegativeAmountException thrown if amount is negative.
   */
  public void addMoney(Integer amount) throws PlayerNotInGameException, NegativeAmountException;

  /**
   * Removes a given amount of money from the player.
   * @param amount amount of money.
   * @throws PlayerNotInGameException thrown if the player, who is not in the game.
   * @throws NegativeAmountException thrown if amount is negative.
   */
  public void removeMoney(Integer amount) throws PlayerNotInGameException, NegativeAmountException;

  /**
   * Gets if the player is in game or not.
   * @return True if the player is in game, else false.
   */
  public Boolean isInGame();
  
}