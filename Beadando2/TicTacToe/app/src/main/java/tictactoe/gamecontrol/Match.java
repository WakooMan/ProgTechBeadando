package tictactoe.gamecontrol;

import tictactoe.table.Table;
import java.util.*;
import static tictactoe.gamecontrol.MatchResult.Draw;
import static tictactoe.gamecontrol.MatchResult.O;
import static tictactoe.gamecontrol.MatchResult.X;
import tictactoe.table.Signal;

/**
 * Represents a match in the tictactoe game.
 */
public class Match {
  
  private final List<MatchListener> listeners;
    
  private final String name;
    
  private final Table table;

  private final HashMap<Signal, Player> players;

  private Signal currentPlayer;

  private final ITableObserver tableObserver;

  /**
   * Constructor.
   * @param name name of match.
   * @param columnNum column number.
   * @param rowNum row number.
   * @param player1 player1's name.
   * @param player2 player2's name.
   */
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

  /**
   * Steps, with the current player at the specified column.
   * @param column column.
   */
  public void stepWithCurrentPlayer(int column) {
      players.get(currentPlayer).doCommand(column).execute(table);
      players.get(currentPlayer).afterPlayerStepped();
      for(int i=0; i < table.getColumnNum(); i++)
      {
          if(this.tableObserver.isColumnFull(i))
          {
              for(MatchListener listener : listeners)
              {
                  listener.onColumnFilled(i);
              }
          }
      }
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

  /**
   * Gets if the game is over based on the table's state.
   * @return True if game is over, else false.
   */
  public Boolean isGameOver() {
      return tableObserver.checkDiagonal() == 1 || tableObserver.checkRows() == 1 || tableObserver.isTableFull();
  }

  /**
   * Gets the table in the match.
   * @return table.
   */
  public Table getTable() {
      return table;
  }
  
  /**
   * Gets the players in the match.
   * @return Player list.
   */
  public List<Player> getPlayers()
  {
      return new ArrayList<>(players.values());
  }
  
  /**
   * Gets the current player.
   * @return Current player.
   */
  public Player getCurrentPlayer()
  {
      return players.get(currentPlayer);
  }
  
  /**
   * Gets the name of the match.
   * @return Name of the match.
   */
  public String getName()
  {
      return this.name;
  }
  
  /**
   * Adds a match listener.
   * @param listener MatchListener object.
   */
  public void addMatchListener(MatchListener listener)
  {
      listeners.add(listener);
  }
  
  /**
   * Clears the match.
   */
  public void clear()
  {
    table.clearTable();
    for(int i=0; i < table.getColumnNum(); i++)
    {
        for(MatchListener listener : listeners)
        {
          listener.onColumnCleared(i);
        }
    }
    
    if(currentPlayer == Signal.X)
    {
        players.get(currentPlayer).afterPlayerStepped();
        currentPlayer = Signal.O;
        players.get(currentPlayer).onPlayerTurn();
    }
  }

}