package tictactoe.gamecontrol;

public interface ITableObserver {

  public int checkRows();

  public int checkDiagonal();
  
  public boolean isTableFull();
  
  public MatchResult getMatchResult();

}