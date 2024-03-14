package tictactoe.applicationstates;

import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.mainmenu.MainMenu;

public class InMainMenu implements IApplicationState {

  private final IMenu mainMenu;

  public InMainMenu() {
      this.mainMenu = new MainMenu();
  }

  @Override
  public void doAction() {
      
  }

}