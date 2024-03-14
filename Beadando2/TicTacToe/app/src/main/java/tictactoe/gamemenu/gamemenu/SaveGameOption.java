package tictactoe.gamemenu.gamemenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.gamecontrol.Match;
import tictactoe.gamecontrol.ISaveHandler;
import tictactoe.gamecontrol.ObjectComponentUtils;

public class SaveGameOption implements IMenuOption {

  private final Match match;

  private final ISaveHandler saveHandler;

  public SaveGameOption(Match match) {
      this.match = match;
      this.saveHandler = ObjectComponentUtils.getDefaultSaveHandler();
  }

  @Override
  public void doOption() {
      saveHandler.save(match);
  }

}