package tictactoe.gamecontrol;

/**
 * Abstract interface, which represents what should be checked on the table.
 */
public interface ITableObserver {

  /**
   * Checks the rows in the table for 4 signs in a row.
   * @return 0 if 4 O or X signal is not found in any row after each other, else 1.
   */
  public int checkRows();

  /**
   * Checks the table diagonally for 4 signs in a row.
   * @return 0 if 4 O or X signal is not found diagonally after each other, else 1.
   */
  public int checkDiagonal();
  
  /**
   * Checks if table is full of signals.
   * @return True if Signal.Empty signal not found on table, else false.
   */
  public boolean isTableFull();
  
  /**
   * Checks if column is full on the table.
   * @param column column to be checked.
   * @return True if Signal.Empty signal not found in column of the table, else false.
   */
  public boolean isColumnFull(int column);
  
  public MatchResult getMatchResult();

}