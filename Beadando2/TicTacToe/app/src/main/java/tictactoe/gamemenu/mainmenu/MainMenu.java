package tictactoe.gamemenu.mainmenu;

import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamemenu.IMenu;
import java.util.*;

/**
 * Represents the main menu of the Tic Tac Toe game.
 */
public class MainMenu implements IMenu {

  // List to hold main menu options
  private final List<IMenuOption> mainMenuOptions;

  /**
   * Constructs a new instance of the MainMenu class.
   */
  public MainMenu() {
      this.mainMenuOptions = new ArrayList<>();
      // Add main menu options
      this.mainMenuOptions.add(new StartGameOption());
      this.mainMenuOptions.add(new ExitGameOption());
  }

  /**
   * Retrieves the list of main menu options.
   * @return The list of main menu options.
   */
  @Override
  public List<IMenuOption> getOptions() {
    return mainMenuOptions;
  }

  /**
   * Performs the action associated with the selected main menu option.
   * @param index The index of the selected option.
   */
  @Override
  public void doOption(int index) {
      mainMenuOptions.get(index).doOption();
  }
}
