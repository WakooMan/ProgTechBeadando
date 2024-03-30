package tictactoe.gamecontrol;

import tictactoe.table.Table;

/**
 * Abstract interface for player commands on the table.
 */
public interface IPlayerCommand {

  /**
   * Executes the command on the table.
   * @param table table, on which the command is executed.
   */
  public void execute(Table table);

}