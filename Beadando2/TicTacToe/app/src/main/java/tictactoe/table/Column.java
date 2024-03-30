package tictactoe.table;

import java.util.*;

/**
 * Represents a column in the Tic Tac Toe table.
 */
public class Column extends AbstractList<Field> {

  // List to hold fields in the column
  private final List<Field> fields;

  /**
   * Constructs a new instance of the Column class.
   * @param m The number of fields in the column.
   */
  public Column(int m) {
      fields = new ArrayList<>();
      // Initialize fields with empty signals
      for(int i = 0; i < m; i++) {
        fields.add(new Field(Signal.Empty));
      }
  }

  /**
   * Gets the field at the specified index in the column.
   * @param index The index of the field to retrieve.
   * @return The field at the specified index.
   */
  @Override
  public Field get(int index) {
    return fields.get(index);
  }

  /**
   * Gets the size of the column (number of fields).
   * @return The size of the column.
   */
  @Override
  public int size() {
    return fields.size();
  }
}
