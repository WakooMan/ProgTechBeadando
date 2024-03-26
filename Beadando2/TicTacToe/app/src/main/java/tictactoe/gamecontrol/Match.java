package tictactoe.gamecontrol;

import tictactoe.table.Table;
import java.util.*;
import tictactoe.table.Signal;

public class Match {
  
  private final String name;
    
  private final Table table;

  private final List<Player> players;

  private int currentPlayer;

  private final ITableObserver tableObserver;

  public Match(String name, Table table, Player player1, Player player2, int currentPlayer) {
      this.name = name;
      this.table = table;
      this.players = new ArrayList<>();
      players.add(player1);
      players.add(player2);
      this.currentPlayer = currentPlayer;
      tableObserver = new TableObserver(table);
  }

  public Match(String name, int n, int m, String player1, String player2) {
      this.name = name;
      this.table = new Table(n, m);
      this.players = new ArrayList<>();
      players.add(new Player(player1, Signal.O));
      players.add(new Player(player2, Signal.X));
      currentPlayer = 0;
      tableObserver = new TableObserver(table);
  }

  public void stepWithCurrentPlayer(int column) {
      players.get(currentPlayer).doCommand(column).execute(table);
      players.get(currentPlayer).afterPlayerStepped();
      currentPlayer = (currentPlayer == 0) ? 1 : 0;
      players.get(currentPlayer).onPlayerTurn();
      
      if(isGameOver())
      {
          // should be changed to GameOver state.
      }
  }

  public Boolean isGameOver() {
    return tableObserver.checkDiagonal() > 0 || tableObserver.checkRows() > 0;
  }

  public Table getTable() {
    return table;
  }
  
  public List<Player> getPlayers()
  {
      return players;
  }
  
  public Player getCurrentPlayer()
  {
      return players.get(currentPlayer);
  }
  
  public String getName()
  {
      return this.name;
  }

}