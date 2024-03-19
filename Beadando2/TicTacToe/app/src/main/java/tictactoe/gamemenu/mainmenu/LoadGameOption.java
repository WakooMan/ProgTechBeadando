package tictactoe.gamemenu.mainmenu;
import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InSavedGamesMenu;
import tictactoe.gamemenu.IMenuOption;

public class LoadGameOption implements IMenuOption {

  public LoadGameOption() {
  }

  @Override
  public void doOption() {
      ApplicationStateManager.getInstance().changeState(new InSavedGamesMenu());
  }

  @Override
  public String getTitle(){
      return "Load Game";
  }
  
}