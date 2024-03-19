package tictactoe.applicationstates;

import tictactoe.ObjectComponentUtils;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.mainmenu.MainMenu;
import tictactoe.views.View;

public class InMainMenu extends ApplicationState {
  private final IMenu mainMenu;

  public InMainMenu() {
      
      this.mainMenu = new MainMenu();
  }
  
  public IMenu getMainMenu()
  {
      return mainMenu;
  }

    @Override
    public View getView() {
        return ObjectComponentUtils.getMainMenuView();
    }
  
  

}