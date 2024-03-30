package tictactoe.table;

import java.util.*;

/**
 * Represents the table (board) of the Tic Tac Toe game.
 */
public class Table extends AbstractList<Column> {

  // Number of columns in the table
  private final int columnNum;
  // Number of rows in each column
  private final int rowNum;
  // List to hold columns of the table
  private final List<Column> columns;
  
  /**
   * Constructs a new instance of the Table class.
   * @param columnNum The number of columns in the table.
   * @param rowNum The number of rows in each column.
   */
  public Table(int columnNum, int rowNum) {
      this.columnNum = columnNum;
      this.rowNum = rowNum;
      // Initialize columns of the table
      columns = new ArrayList<>();
      for(int i = 0; i < columnNum; i++) {
        columns.add(new Column(rowNum));
      }
  }

  /**
   * Gets the column at the specified index in the table.
   * @param index The index of the column to retrieve.
   * @return The column at the specified index.
   */
  @Override
  public Column get(int index) {
    return columns.get(index);
  }
  
  /**
   * Gets the field at the specified position in the table.
   * @param column The index of the column.
   * @param row The index of the row.
   * @return The field at the specified position.
   */
  public Field get(int column, int row) {
    return columns.get(column).get(row);
  }
  
  /**
   * Gets the number of columns in the table.
   * @return The number of columns.
   */
  public int getColumnNum() {
    return columnNum;
  }
  
  /**
   * Gets the number of rows in each column of the table.
   * @return The number of rows.
   */
  public int getRowNum() {
      return rowNum;
  }
  
  /**
   * Clears all fields in the table by setting their signals to empty.
   */
  public void clearTable() {
      for(int column = 0; column < columnNum; column++) {
        for(int row = 0; row < rowNum; row++) {
            get(column,row).setSignal(Signal.Empty);
        }
      }
  }

  /**
   * Gets the size of the table (number of columns).
   * @return The size of the table.
   */
  @Override
  public int size() {
    return columns.size();
  }

}
