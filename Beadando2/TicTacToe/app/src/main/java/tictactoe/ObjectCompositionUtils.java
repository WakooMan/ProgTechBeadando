package tictactoe;

import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamecontrol.MatchFactory;
import tictactoe.views.View;
import tictactoe.views.initializegameview.InitializeGameView;
import tictactoe.views.mainmenu.MainMenuView;
import tictactoe.views.tictactoeview.TicTacToeGameView;

/**
 * Responsible for containing singleton objects for different type of objects.
 */
public class ObjectCompositionUtils {
    
  private static IMatchFactory matchFactory;
  
  private static View mainMenuView;
  
  private static View initializeGameMenuView;
  
  private static View ticTacToeGameView;

  /**
   * Gets the default IMatchFactory object.
   * @return The default IMatchFactory object.
   */
  public static IMatchFactory getDefaultMatchFactory() {
    if(matchFactory == null)
    {
       matchFactory = new MatchFactory();
    }
    return matchFactory;
  }
  
  /**
   * Gets the MainMenu's View object.
   * @return MainMenu's View object.
   */
   public static View getMainMenuView() {
    if(mainMenuView == null)
    {
       mainMenuView = new MainMenuView();
    }
    return mainMenuView;
  }
   
   /**
   * Gets the InitializeGameMenu's View object.
   * @return InitializeGameMenu's View object.
   */
   public static View getInitializeGameMenuView() {
   if(initializeGameMenuView == null)
    {
       initializeGameMenuView = new InitializeGameView();
    }
    return initializeGameMenuView;
   }
   
   /**
   * Gets the TicTacToeGame's View object.
   * @return TicTacToeGame's View object.
   */
   public static View getTicTacToeGameView() {
   if(ticTacToeGameView == null)
    {
       ticTacToeGameView = new TicTacToeGameView();
    }
    return ticTacToeGameView;
   }

}