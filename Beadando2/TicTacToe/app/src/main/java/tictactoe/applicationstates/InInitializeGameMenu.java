package tictactoe.applicationstates;

import tictactoe.ObjectCompositionUtils;
import tictactoe.exceptions.FieldNumberOutOfRangeException;
import tictactoe.exceptions.StringIsNotValidException;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.initializegamemenu.InitializeGameMenu;
import tictactoe.views.View;

/**
 * Application state for the InitializeGameMenu
 */
public class InInitializeGameMenu extends ApplicationState {
    
  private static final String STR_REGEX_PATTERN = "^[A-Za-z0-9.]{1,255}$";
  private final IMenu initializeGameMenu;
  private int columnNum;

  private int rowNum;
  
  private String player1 = "";
  
  private String player2 = "";
  
  private String matchName = "";

  /**
   * Default Constructor.
   */
  public InInitializeGameMenu() {
      initializeGameMenu = new InitializeGameMenu(this);
  }
  
  /**
   * Gets the IMenu object of initialize game menu.
   * @return IMenu object of initialize game menu.
   */
  public IMenu getInitializeGameMenu()
  {
      return initializeGameMenu;
  }

    /**
   * {@inheritDoc}
   */
    @Override
    public View getView() {
        return ObjectCompositionUtils.getInitializeGameMenuView();
    }
    
   /**
   * Gets the Player1's name.
   * @return Player1's name.
   */
    public String getPlayer1()
    {
        return player1;
    }
    
    /**
   * Gets the Player2's name.
   * @return Player2's name.
   */
    public String getPlayer2()
    {
        return player2;
    }
    
   /**
   * Gets the match name.
   * @return Match name.
   */
     public String getMatchName()
    {
        return matchName;
    }
    
   /**
   * Gets the column number on the table.
   * @return Column number.
   */
    public int getColumnNum()
    {
        return columnNum;
    }
    
   /**
   * Gets the row number on the table.
   * @return Row number.
   */
    public int getRowNum()
    {
        return rowNum;
    }
    
    /**
     * Sets the Player1's name.
     * @param player1 Player1's name new value.
     * @throws StringIsNotValidException thrown if name contains invalid characters or equals to player2's name or length is less than 1.
     */
    public void setPlayer1(String player1) throws StringIsNotValidException
    {
        this.player1 = player1;
        if(isPlayerInvalid(player1, player2))
        {
            throw new StringIsNotValidException();
        }
    }
    
    /**
     * Sets the Player2's name.
     * @param player2 Player2's name new value.
     * @throws StringIsNotValidException thrown if name contains invalid characters or equals to player2's name or length is less than 1.
     */
    public void setPlayer2(String player2) throws StringIsNotValidException
    {
        this.player2 = player2;
        if(isPlayerInvalid(player2, player1))
        {
            throw new StringIsNotValidException();
        }
    }
    
    /**
     * Sets the match name.
     * @param matchName new value of match name.
     * @throws StringIsNotValidException thrown if name contains invalid characters or less than 1.
     */
    public void setMatchName(String matchName) throws StringIsNotValidException
    {
        this.matchName = matchName;
        if(isMatchNameInvalid(matchName))
        {
            throw new StringIsNotValidException();
        }
    }
    
    /**
     * Sets the column number of the table.
     * @param columnNum Column number new value.
     * @throws FieldNumberOutOfRangeException thrown if column number is less than 4 or more than 20.
     */
    public void setColumnNum(int columnNum) throws FieldNumberOutOfRangeException
    {
        this.columnNum = columnNum;
        if(isFieldNumberInvalid(columnNum))
        {
            throw new FieldNumberOutOfRangeException();
        }
    }
    
    /**
     * Sets the row number of the table.
     * @param rowNum Row number new value.
     * @throws FieldNumberOutOfRangeException thrown if row number is less than 4 or more than 20.
     */
    public void setRowNum(int rowNum) throws FieldNumberOutOfRangeException
    {
        this.rowNum = rowNum;
        if(isFieldNumberInvalid(rowNum))
        {
            throw new FieldNumberOutOfRangeException();
        }
    }
    
    private boolean isFieldNumberInvalid(int num)
    {
        return num > 20 || num < 4;
    }
    
    private boolean isMatchNameInvalid(String matchName)
    {
        return matchName.length() < 1 || !matchName.matches(STR_REGEX_PATTERN);
    }
    
    private boolean isPlayerInvalid(String player, String otherPlayer)
    {
        return player.length() < 1 || !player.matches(STR_REGEX_PATTERN) || otherPlayer.equals(player);
    }
    
    /**
     * Checks if any of the inputs are invalid. Return true if one of them is invalid, else false.
     * @return True if one of the inputs are invalid, else false.
     */
    public boolean areInputsInvalid()
    {
        return isFieldNumberInvalid(columnNum) || 
                isFieldNumberInvalid(rowNum) || 
                isMatchNameInvalid(matchName) || 
                isPlayerInvalid(player1, player2) ||
                isPlayerInvalid(player2, player1);
    }
}