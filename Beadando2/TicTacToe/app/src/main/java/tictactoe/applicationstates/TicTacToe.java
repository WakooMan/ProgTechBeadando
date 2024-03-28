package tictactoe.applicationstates;

import java.util.List;
import tictactoe.ObjectComponentUtils;
import tictactoe.gamecontrol.Match;
import tictactoe.gamecontrol.MatchListener;
import tictactoe.gamecontrol.Player;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamemenu.tictactoemenu.TicTacToeMenuOption;
import tictactoe.gamemenu.tictactoemenu.TicTacToeNewGameOption;
import tictactoe.table.Field;
import tictactoe.views.View;

public class TicTacToe extends ApplicationState {

  private final Match match;
  private final IMenuOption menuOption;
  private final IMenuOption newGameOption;

  public TicTacToe(Match match) {
      this.menuOption = new TicTacToeMenuOption();
      this.newGameOption = new TicTacToeNewGameOption();
      this.match = match;
  }

    public IMenuOption getMenuOption()
    {
        return menuOption;
    }
    
    public IMenuOption getNewGameOption()
    {
        return newGameOption;
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
    
    public int getColumnNum()
    {
        return this.match.getTable().getColumnNum();
    }
    
    public int getRowNum()
    {
        return this.match.getTable().getRowNum();
    }
    
    public Player getCurrentPlayer()
    {
        return this.match.getCurrentPlayer();
    }
    
    public void throwWithCurrentPlayerAt(int column)
    {
        this.match.stepWithCurrentPlayer(column);
    }
    
    public void clearMatch()
    {
        this.match.clear();
    }
    
    public void addMatchListener(MatchListener listener)
    {
        this.match.addMatchListener(listener);
    }
    
    
}