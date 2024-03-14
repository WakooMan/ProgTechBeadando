package tictactoe.table;

import java.util.*;

public class Table extends AbstractList<Column> {

  private final List<Column> columns;
  
  public Table(int n, int m) {
      columns = new ArrayList<>();
      for(int i = 0; i < n; i++)
      {
        columns.add(new Column(m));
      }
  }

  @Override
  public Column get(int index) {
  return columns.get(index);
  }

  @Override
  public int size() {
  return columns.size();
  }

}