package tictactoe.gamemenu;

import java.util.*;

public interface IMenu {

  public List<IMenuOption> getOptions();

  public void doOption(int index);

}