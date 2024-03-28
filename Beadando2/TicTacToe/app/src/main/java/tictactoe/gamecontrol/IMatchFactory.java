package tictactoe.gamecontrol;

public interface IMatchFactory {

  public Match create(String name, int columnNum, int rowNum, String player1, String player2);

}