package tictactoe.gamemenu.mainmenu;

import tictactoe.gamemenu.IMenuOption;

/**
 * Represents the "Exit Game" option in the main menu.
 */
public class ExitGameOption implements IMenuOption {

  /**
   * Constructs a new instance of the ExitGameOption class.
   */
  public ExitGameOption() {
    // Constructor
  }

  /**
   * Performs the action associated with selecting the "Exit Game" option.
   * Exits the application.
   */
  @Override
  public void doOption() {
    System.exit(0); // Exit the application
  }
  
  /**
   * Gets the title of the "Exit Game" option.
   * @return The title of the option, which is "Exit Game".
   */
  @Override
  public String getTitle(){
    return "Exit Game"; // Return the title of the option
  }
}
