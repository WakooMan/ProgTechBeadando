package tictactoe.gamecontrol;

import java.util.List;

public interface ITableObserver {

  public int checkRows();

  public int checkDiagonal();

}