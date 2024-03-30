package tictactoe.applicationstates;

import tictactoe.ObjectCompositionUtils;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.mainmenu.MainMenu;
import tictactoe.views.View;

/**
 * Application state for the MainMenu
 */
public class InMainMenu extends ApplicationState {
  private final IMenu mainMenu;

  /**
   * Default Constructor.
   */
  public InMainMenu() {
      
      this.mainMenu = new MainMenu();
  }
  
  /**
   * Gets the IMenu object of main menu.
   * @return IMenu object of main menu.
   */
  public IMenu getMainMenu()
  {
      return mainMenu;
  }

    /**
   * {@inheritDoc}
   */
    @Override
    public View getView() {
        return ObjectCompositionUtils.getMainMenuView();
    }
  
  

}