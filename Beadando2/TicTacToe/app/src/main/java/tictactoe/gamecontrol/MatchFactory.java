package tictactoe.gamecontrol;

public class MatchFactory implements IMatchFactory {

  public MatchFactory() {
  }
  
  @Override
  public Match create(String name, int n, int m, String player1, String player2) {
    return new Match(name, n, m, player1, player2);
  }

}