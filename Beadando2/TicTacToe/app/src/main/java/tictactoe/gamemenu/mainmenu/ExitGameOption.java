package tictactoe.gamemenu.mainmenu;
import tictactoe.gamemenu.IMenuOption;

public class ExitGameOption implements IMenuOption {

  public ExitGameOption() {
  }

  @Override
  public void doOption() {
      System.exit(0);
  }
  
  @Override
  public String getTitle(){
      return "Exit Game";
  }

}