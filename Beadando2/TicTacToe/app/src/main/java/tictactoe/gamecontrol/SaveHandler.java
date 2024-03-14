package tictactoe.gamecontrol;
import java.util.*;

public class SaveHandler implements ISaveHandler {

  public String savedGamesPath;

  public SaveHandler(String savedGamesPath) {
      this.savedGamesPath = savedGamesPath;
  }

  public List<String> getSavedGames() {
    return null;
  }

  public String getSavedGame(int index) {
    return null;
  }

  public void save(Match match) {
  }

  public Match load(String name) {
    return null;
  }

}