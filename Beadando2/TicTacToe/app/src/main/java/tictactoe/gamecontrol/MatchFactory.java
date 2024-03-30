package tictactoe.gamecontrol;

/**
 * Responsible for creating a new match.
 */
public class MatchFactory implements IMatchFactory {

  /**
   * Default Constructor.
   */
  public MatchFactory() {
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Match create(String name, int columnNum, int rowNum, String player1, String player2) {
    return new Match(name, columnNum, rowNum, player1, player2);
  }

}