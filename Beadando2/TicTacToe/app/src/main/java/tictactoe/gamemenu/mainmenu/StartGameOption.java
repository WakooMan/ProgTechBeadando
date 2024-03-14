package tictactoe.gamemenu.mainmenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamecontrol.ObjectComponentUtils;

public class StartGameOption implements IMenuOption {

   private final IMatchFactory matchFactory;
    
  public StartGameOption() {
    this.matchFactory = ObjectComponentUtils.getDefaultMatchFactory();
  }

  @Override
  public void doOption() {
      //Set next state to TicTacToe with created match.
  }

}