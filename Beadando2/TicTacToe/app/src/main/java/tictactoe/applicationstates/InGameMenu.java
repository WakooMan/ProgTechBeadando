package tictactoe.applicationstates;

import tictactoe.gamecontrol.Match;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.gamemenu.GameMenu;
import tictactoe.views.View;

public class InGameMenu extends ApplicationState {

  private final IMenu gameMenu;

  public InGameMenu(Match match) {
      this.gameMenu = new GameMenu(match);
  }

  @Override
  public View getView() {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}