package tictactoe.gamecontrol;

public interface IMatchFactory {

  public Match create(String name, int n, int m, String player1, String player2);

}