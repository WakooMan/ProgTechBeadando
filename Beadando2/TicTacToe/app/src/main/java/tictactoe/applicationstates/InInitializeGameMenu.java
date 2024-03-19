package tictactoe.applicationstates;

import tictactoe.ObjectComponentUtils;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.initializegamemenu.InitializeGameMenu;
import tictactoe.views.View;

public class InInitializeGameMenu extends ApplicationState {
  private final IMenu initializeGameMenu;
  private int n;

  private int m;
  
  private String player1;
  
  private String player2;
  
  private String matchName;

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
    
    public void setPlayer1(String player1)
    {
        this.player1 = player1;
    }
    
    public void setPlayer2(String player2)
    {
        this.player2 = player2;
    }
    
    public void setMatchName(String matchName)
    {
        this.matchName = matchName;
    }
    
    public void setN(int n)
    {
        this.n = n;
    }
    
    public void setM(int m)
    {
        this.m = m;
    }
}