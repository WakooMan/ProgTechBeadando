package tictactoe.gamemenu.mainmenu;
import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenuOption;

public class StartGameOption implements IMenuOption {
    
  public StartGameOption() {
  }

  @Override
  public void doOption() {
     ApplicationStateManager.getInstance().changeState(new InInitializeGameMenu());
  }
  
  @Override
  public String getTitle(){
      return "Start Game";
  }
}