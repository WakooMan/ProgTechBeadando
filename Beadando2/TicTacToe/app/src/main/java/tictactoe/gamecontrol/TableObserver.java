package tictactoe.gamecontrol;

import tictactoe.table.Table;

public class TableObserver implements ITableObserver {

  private final Table table;

  public TableObserver(Table table) {
      this.table = table;
  }

  public int checkRows() {
    return 0;
  }

  public int checkDiagonal() {
    return 0;
  }

}