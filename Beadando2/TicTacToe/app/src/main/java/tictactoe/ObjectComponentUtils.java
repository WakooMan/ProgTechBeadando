package tictactoe;

import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamecontrol.MatchFactory;
import tictactoe.views.View;
import tictactoe.views.initializegameview.InitializeGameView;
import tictactoe.views.mainmenu.MainMenuView;
import tictactoe.views.tictactoeview.TicTacToeGameView;

public class ObjectComponentUtils {
    
  private static IMatchFactory matchFactory;
  
  private static View mainMenuView;
  
  private static View initializeGameMenuView;
  
  private static View ticTacToeGameView;

  public static IMatchFactory getDefaultMatchFactory() {
    if(matchFactory == null)
    {
       matchFactory = new MatchFactory();
    }
    return matchFactory;
  }
  
   public static View getMainMenuView() {
    if(mainMenuView == null)
    {
       mainMenuView = new MainMenuView();
    }
    return mainMenuView;
  }
   
   public static View getInitializeGameMenuView() {
   if(initializeGameMenuView == null)
    {
       initializeGameMenuView = new InitializeGameView();
    }
    return initializeGameMenuView;
   }
   
   public static View getTicTacToeGameView() {
   if(ticTacToeGameView == null)
    {
       ticTacToeGameView = new TicTacToeGameView();
    }
    return ticTacToeGameView;
   }

}