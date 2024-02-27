package capitaly.players;

import capitaly.exceptions.NegativeAmountException;
import capitaly.exceptions.NotEnoughTestRandomNumberException;
import capitaly.exceptions.PlayerNotInGameException;

public interface IPlayer {

  public void step() throws PlayerNotInGameException, NotEnoughTestRandomNumberException;

  public void payTo(IPlayer player, Integer amount) throws PlayerNotInGameException, NegativeAmountException;

  public void addMoney(Integer amount) throws PlayerNotInGameException, NegativeAmountException;

  public void removeMoney(Integer amount) throws PlayerNotInGameException, NegativeAmountException;

  public Boolean isInGame();
  
}