package tictactoe.gamecontrol;

public class MatchFactory implements IMatchFactory {

  public MatchFactory() {
  }
  
  @Override
  public Match create(String name, int columnNum, int rowNum, String player1, String player2) {
    return new Match(name, columnNum, rowNum, player1, player2);
  }

}