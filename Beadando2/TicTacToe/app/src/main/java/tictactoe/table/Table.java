package tictactoe.table;

import java.util.*;

public class Table extends AbstractList<Column> {

  private final int n;
  private final int m;
  private final List<Column> columns;
  
  public Table(int n, int m) {
      this.n = n;
      this.m = m;
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
  
  public Field get(int i, int j) {
  return columns.get(i).get(j);
  }
  
  public int getN() {
    return n;
  }
  
  public int getM() {
      return m;
  }

  @Override
  public int size() {
  return columns.size();
  }

}