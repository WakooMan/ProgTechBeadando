package tictactoe.gamemenu.gamemenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamemenu.IMenu;
import java.util.*;
import tictactoe.gamecontrol.Match;

public class GameMenu implements IMenu {

  private final List<IMenuOption> gameMenuOptions;

  public GameMenu(Match match) {
      this.gameMenuOptions = new ArrayList<>();
      this.gameMenuOptions.add(new ResumeGameOption());
      this.gameMenuOptions.add(new SaveGameOption(match));
      this.gameMenuOptions.add(new BackToMenuOption());
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