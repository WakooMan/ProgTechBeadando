package tictactoe.gamecontrol;
import java.util.*;

public interface ISaveHandler {

  public List<String> getSavedGames();

  public String getSavedGame(int index);

  public void save(Match match);

  public Match load(String name);

}