package tictactoe.gamemenu.initializegamemenu;

import java.util.ArrayList;
import java.util.List;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.IMenuOption;

public class InitializeGameMenu implements IMenu {
    private final List<IMenuOption> gameMenuOptions;

  public InitializeGameMenu(InInitializeGameMenu gameMenu) {
      this.gameMenuOptions = new ArrayList<>();
      this.gameMenuOptions.add(new BackOption());
      this.gameMenuOptions.add(new StartOption(gameMenu));
  }

  @Override
  public List<IMenuOption> getOptions() {
    return gameMenuOptions;
  }

  @Override
  public void doOption(int index) {
      this.gameMenuOptions.get(index).doOption();
  }
}
