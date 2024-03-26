package tictactoe.applicationstates;

import java.util.List;
import tictactoe.ObjectComponentUtils;
import tictactoe.gamecontrol.Match;
import tictactoe.gamecontrol.Player;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamemenu.TicTacToeMenuOption;
import tictactoe.table.Field;
import tictactoe.views.View;

public class TicTacToe extends ApplicationState {

  private final Match match;
  private final IMenuOption gameMenuOption;

  public TicTacToe(Match match) {
      this.gameMenuOption = new TicTacToeMenuOption(match);
      this.match = match;
  }

    public IMenuOption getGameMenuOption()
    {
        return gameMenuOption;
    }
  
    @Override
    public View getView() {
        return ObjectComponentUtils.getTicTacToeGameView();
    }
    
    public Field getField(int i, int j)
    {
        return this.match.getTable().get(i, j);
    }
    
    public List<Player> getPlayers()
    {
        return this.match.getPlayers();
    }
    
    public int getN()
    {
        return this.match.getTable().getN();
    }
    
    public int getM()
    {
        return this.match.getTable().getM();
    }
    
    public Player getCurrentPlayer()
    {
        return this.match.getCurrentPlayer();
    }
    
    public void throwWithCurrentPlayerAt(int column)
    {
        this.match.stepWithCurrentPlayer(column);
    }
}