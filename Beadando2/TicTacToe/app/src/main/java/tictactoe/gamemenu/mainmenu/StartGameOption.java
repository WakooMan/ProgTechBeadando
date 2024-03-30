package tictactoe.gamemenu.mainmenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 * Represents the "Start Game" option in the main menu.
 */
public class StartGameOption implements IMenuOption {
    
  /**
   * Constructs a new instance of the StartGameOption class.
   */
  public StartGameOption() {
    // Constructor
  }

  /**
   * Performs the action associated with selecting the "Start Game" option.
   * Changes the application state to the initialized game menu state.
   */
  @Override
  public void doOption() {
     ApplicationStateManager.getInstance().changeState(new InInitializeGameMenu());
  }
  
  /**
   * Gets the title of the "Start Game" option.
   * @return The title of the option, which is "Start Game".
   */
  @Override
  public String getTitle(){
      return "Start Game";
  }
}
