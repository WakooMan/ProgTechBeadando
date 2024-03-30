package tictactoe.applicationstates;

import java.util.List;
import tictactoe.ObjectCompositionUtils;
import tictactoe.gamecontrol.Match;
import tictactoe.gamecontrol.MatchListener;
import tictactoe.gamecontrol.Player;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamemenu.tictactoemenu.TicTacToeMenuOption;
import tictactoe.gamemenu.tictactoemenu.TicTacToeNewGameOption;
import tictactoe.table.Field;
import tictactoe.views.View;

/**
 * Application state of the tictactoe game.
 */
public class TicTacToe extends ApplicationState {

  private final Match match;
  private final IMenuOption menuOption;
  private final IMenuOption newGameOption;

    /**
    * Constructor
    * @param match Match.
    */
    public TicTacToe(Match match) {
        this.menuOption = new TicTacToeMenuOption();
        this.newGameOption = new TicTacToeNewGameOption();
        this.match = match;
    }

    /**
     * Gets the Menu option to be able to go back to main menu.
     * @return Menu option.
     */
    public IMenuOption getMenuOption()
    {
        return menuOption;
    }
    
    /**
     * Gets the Menu option to be able to go back to initialize game menu.
     * @return Menu option.
     */
    public IMenuOption getNewGameOption()
    {
        return newGameOption;
    }
  
   /**
   * {@inheritDoc}
   */
    @Override
    public View getView() {
        return ObjectCompositionUtils.getTicTacToeGameView();
    }
    
    /**
     * Gets the field on the table at the column with index i and row at index j.
     * @param i Column index.
     * @param j Row index.
     * @return Field object on table.
     */
    public Field getField(int i, int j)
    {
        return this.match.getTable().get(i, j);
    }
    
    /**
     * Gets the players of the match.
     * @return Players of the match.
     */
    public List<Player> getPlayers()
    {
        return this.match.getPlayers();
    }
    
    /**
   * Gets the column number on the table.
   * @return Column number.
   */
    public int getColumnNum()
    {
        return this.match.getTable().getColumnNum();
    }
    
    /**
   * Gets the row number on the table.
   * @return Row number.
   */
    public int getRowNum()
    {
        return this.match.getTable().getRowNum();
    }
    
    /**
     * Gets the player, who should step currently.
     * @return The player, who should step currently.
     */
    public Player getCurrentPlayer()
    {
        return this.match.getCurrentPlayer();
    }
    
    /**
     * Throws with the current player at the specific column on the table.
     * @param column Specific column on the table.
     */
    public void throwWithCurrentPlayerAt(int column)
    {
        this.match.stepWithCurrentPlayer(column);
    }
    
    /**
     * Clears the match.
     */
    public void clearMatch()
    {
        this.match.clear();
    }
    
    /**
     * Adds a match listener to the match.
     * @param listener Match listener.
     */
    public void addMatchListener(MatchListener listener)
    {
        this.match.addMatchListener(listener);
    }
    
    
}