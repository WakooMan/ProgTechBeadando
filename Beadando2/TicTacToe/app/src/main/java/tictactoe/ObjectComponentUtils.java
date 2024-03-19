package tictactoe;

import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamecontrol.ISaveHandler;
import tictactoe.gamecontrol.MatchFactory;
import tictactoe.gamecontrol.SaveHandler;
import tictactoe.views.View;
import tictactoe.views.initializegameview.InitializeGameView;
import tictactoe.views.mainmenu.MainMenuView;

public class ObjectComponentUtils {
    
  private static IMatchFactory matchFactory;

  private static ISaveHandler saveHandler;
  
  private static View mainMenuView;
  
  private static View initializeGameMenuView;

  public static IMatchFactory getDefaultMatchFactory() {
    if(matchFactory == null)
    {
       matchFactory = new MatchFactory();
    }
    return matchFactory;
  }

  public static ISaveHandler getDefaultSaveHandler() {
    if(saveHandler == null)
    {
       saveHandler = new SaveHandler("saves");
    }
    return saveHandler;
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

}