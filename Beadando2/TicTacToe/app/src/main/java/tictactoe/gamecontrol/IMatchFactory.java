package tictactoe.gamecontrol;

/**
 * Abstract interface for match factory.
 */
public interface IMatchFactory {

  /**
   * Creates a match with the given parameters.
   * @param name name of the match.
   * @param columnNum column number.
   * @param rowNum row number.
   * @param player1 player1's name.
   * @param player2 player2's name.
   * @return new match.
   */
  public Match create(String name, int columnNum, int rowNum, String player1, String player2);

}