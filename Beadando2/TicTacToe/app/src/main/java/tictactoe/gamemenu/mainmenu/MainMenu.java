package tictactoe.gamemenu.mainmenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamemenu.IMenu;

import java.util.*;

public class MainMenu implements IMenu {

  private final List<IMenuOption> mainMenuOptions;

  public MainMenu() {
      this.mainMenuOptions = new ArrayList<>();
      this.mainMenuOptions.add(new StartGameOption());
      this.mainMenuOptions.add(new LoadGameOption());
      this.mainMenuOptions.add(new ExitGameOption());
  }

  @Override
  public List<IMenuOption> getOptions() {
    return mainMenuOptions;
  }

  @Override
  public void doOption(int index) {
      mainMenuOptions.get(index).doOption();
  }

}