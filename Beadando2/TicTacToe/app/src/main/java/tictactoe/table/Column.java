package tictactoe.table;

import java.util.*;

public class Column extends AbstractList<Field> {

  private final List<Field> fields;

  public Column(int m) {
      fields = new ArrayList<>();
      for(int i = 0; i < m; i++)
      {
        fields.add(new Field(Signal.Empty));
      }
  }

  @Override
  public Field get(int index) {
  return fields.get(index);
  }

  @Override
  public int size() {
  return fields.size();
  }

}