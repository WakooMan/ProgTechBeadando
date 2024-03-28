package tictactoe.gamecontrol;

import tictactoe.table.Table;
import java.util.*;
import static tictactoe.gamecontrol.MatchResult.Draw;
import static tictactoe.gamecontrol.MatchResult.O;
import static tictactoe.gamecontrol.MatchResult.X;
import tictactoe.table.Signal;

public class Match {
  
  private final List<MatchListener> listeners;
    
  private final String name;
    
  private final Table table;

  private final HashMap<Signal, Player> players;

  private Signal currentPlayer;

  private final ITableObserver tableObserver;

  public Match(String name, Table table, Player player1, Player player2, Signal currentPlayer) {
      this.listeners = new ArrayList<>();
      this.name = name;
      this.table = table;
      this.players = new HashMap<>();
      players.put(player1.getSignal(), player1);
      players.put(player2.getSignal(), player2);
      this.currentPlayer = currentPlayer;
      tableObserver = new TableObserver(table);
  }

  public Match(String name, int columnNum, int rowNum, String player1, String player2) {
      this.listeners = new ArrayList<>();
      this.name = name;
      this.table = new Table(columnNum, rowNum);
      this.players = new HashMap<>();
      players.put(Signal.O, new Player(player1, Signal.O));
      players.put(Signal.X, new Player(player2, Signal.X));
      currentPlayer = Signal.O;
      tableObserver = new TableObserver(table);
  }

  public void stepWithCurrentPlayer(int column) {
      players.get(currentPlayer).doCommand(column).execute(table);
      players.get(currentPlayer).afterPlayerStepped();
      currentPlayer = (currentPlayer == Signal.O) ? Signal.X : Signal.O;
      players.get(currentPlayer).onPlayerTurn();
      if(isGameOver())
      {
          MatchResult result = tableObserver.getMatchResult();
          for(MatchListener listener : listeners)
          switch(result)
          {
              case O -> listener.onGameOver(players.get(Signal.O));
              case X -> listener.onGameOver(players.get(Signal.X));
              case Draw -> listener.onGameOver(null);
              default -> throw new IllegalStateException();
          }
      }
  }

  public Boolean isGameOver() {
      return tableObserver.checkDiagonal() == 1 || tableObserver.checkRows() == 1 || tableObserver.isTableFull();
  }

  public Table getTable() {
      return table;
  }
  
  public List<Player> getPlayers()
  {
      return new ArrayList<>(players.values());
  }
  
  public Player getCurrentPlayer()
  {
      return players.get(currentPlayer);
  }
  
  public String getName()
  {
      return this.name;
  }
  
  public void addMatchListener(MatchListener listener)
  {
      listeners.add(listener);
  }
  
  public void clear()
  {
      table.clearTable();
      if(currentPlayer == Signal.X)
      {
          players.get(currentPlayer).afterPlayerStepped();
          currentPlayer = Signal.O;
          players.get(currentPlayer).onPlayerTurn();
      }
  }

}