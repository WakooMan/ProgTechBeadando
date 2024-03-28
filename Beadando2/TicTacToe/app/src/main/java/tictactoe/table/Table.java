package tictactoe.table;

import java.util.*;

public class Table extends AbstractList<Column> {

  private final int columnNum;
  private final int rowNum;
  private final List<Column> columns;
  
  public Table(int columnNum, int rowNum) {
      this.columnNum = columnNum;
      this.rowNum = rowNum;
      columns = new ArrayList<>();
      for(int i = 0; i < columnNum; i++)
      {
        columns.add(new Column(rowNum));
      }
  }

  @Override
  public Column get(int index) {
  return columns.get(index);
  }
  
  public Field get(int column, int row) {
  return columns.get(column).get(row);
  }
  
  public int getColumnNum() {
    return columnNum;
  }
  
  public int getRowNum() {
      return rowNum;
  }
  
  public void clearTable() {
      for(int column = 0; column < columnNum; column++)
      {
        for(int row = 0; row < rowNum; row++)
        {
            get(column,row).setSignal(Signal.Empty);
        }
      }
  }

  @Override
  public int size() {
  return columns.size();
  }

}