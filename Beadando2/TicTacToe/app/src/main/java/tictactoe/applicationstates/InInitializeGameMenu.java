package tictactoe.applicationstates;

import tictactoe.ObjectComponentUtils;
import tictactoe.exceptions.FieldNumberOutOfRangeException;
import tictactoe.exceptions.StringIsNotValidException;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.initializegamemenu.InitializeGameMenu;
import tictactoe.views.View;

public class InInitializeGameMenu extends ApplicationState {
    
  private static final String STR_REGEX_PATTERN = "^[A-Za-z0-9.]{1,255}$";
  private final IMenu initializeGameMenu;
  private int n;

  private int m;
  
  private String player1 = "";
  
  private String player2 = "";
  
  private String matchName = "";

  public InInitializeGameMenu() {
      initializeGameMenu = new InitializeGameMenu(this);
  }
  
  public IMenu getInitializeGameMenu()
  {
      return initializeGameMenu;
  }

    @Override
    public View getView() {
        return ObjectComponentUtils.getInitializeGameMenuView();
    }
    
    public String getPlayer1()
    {
        return player1;
    }
    
    public String getPlayer2()
    {
        return player2;
    }
    
     public String getMatchName()
    {
        return matchName;
    }
    
    public int getN()
    {
        return n;
    }
    
    public int getM()
    {
        return m;
    }
    
    public void setPlayer1(String player1) throws StringIsNotValidException
    {
        this.player1 = player1;
        if(isPlayerInvalid(player1, player2))
        {
            throw new StringIsNotValidException();
        }
    }
    
    public void setPlayer2(String player2) throws StringIsNotValidException
    {
        this.player2 = player2;
        if(isPlayerInvalid(player2, player1))
        {
            throw new StringIsNotValidException();
        }
    }
    
    public void setMatchName(String matchName) throws StringIsNotValidException
    {
        this.matchName = matchName;
        if(isMatchNameInvalid(matchName))
        {
            throw new StringIsNotValidException();
        }
    }
    
    public void setN(int n) throws FieldNumberOutOfRangeException
    {
        this.n = n;
        if(isFieldNumberInvalid(n))
        {
            throw new FieldNumberOutOfRangeException();
        }
    }
    
    public void setM(int m) throws FieldNumberOutOfRangeException
    {
        this.m = m;
        if(isFieldNumberInvalid(m))
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
    
    public boolean areInputsInvalid()
    {
        return isFieldNumberInvalid(n) || 
                isFieldNumberInvalid(m) || 
                isMatchNameInvalid(matchName) || 
                isPlayerInvalid(player1, player2) ||
                isPlayerInvalid(player2, player1);
    }
}