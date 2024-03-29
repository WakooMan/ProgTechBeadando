package tictactoe.gamecontrol;

public interface ITableObserver {

  public int checkRows();

  public int checkDiagonal();
  
  public boolean isTableFull();
  
  public boolean isColumnFull(int column);
  
  public MatchResult getMatchResult();

}