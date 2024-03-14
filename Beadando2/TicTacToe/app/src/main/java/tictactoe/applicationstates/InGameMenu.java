package tictactoe.applicationstates;

import tictactoe.gamecontrol.Match;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.gamemenu.GameMenu;

public class InGameMenu implements IApplicationState {

  private final IMenu gameMenu;

  public InGameMenu(Match match) {
      this.gameMenu = new GameMenu(match);
  }

  @Override
  public void doAction() {
      
  }

}