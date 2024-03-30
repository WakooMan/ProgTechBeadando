package tictactoe.gamecontrol;

import java.util.ArrayList;
import java.util.List;
import tictactoe.table.Signal;

/**
 * Class, that represents the player.
 */
public class Player {

  private final List<PlayerListener> listeners;
    
  private final String name;

  private final Signal signal;

  /**
   * Constructor.
   * @param name player's name.
   * @param signal signal of the player.
   */
  public Player(String name, Signal signal) {
      this.listeners = new ArrayList<>();
      this.name = name;
      this.signal = signal;
  }

  /**
   * Does a place signal command on the column.
   * @param column column.
   * @return 
   */
  public IPlayerCommand doCommand(int column) {
    return placeSignal(column);
  }

  /**
   * Gets the player's signal.
   * @return Player's signal.
   */
  public Signal getSignal() {
    return signal;
  }

  /**
   * Gets the player's name.
   * @return Player's name.
   */
  public String getName() {
    return name;
  }

  private PlaceSignalPlayerCommand placeSignal(int columnIndex) {
    return new PlaceSignalPlayerCommand(columnIndex, signal);
  }
  
  /**
   * Invokes onPlayerTurn command on PlayerListener.
   */
  public void onPlayerTurn()
  {
      for(PlayerListener listener : listeners)
      {
          listener.onPlayerTurn();
      }
  }
  
  /**
   * Invokes afterPlayerStepped command on PlayerListener.
   */
  public void afterPlayerStepped()
  {
      for(PlayerListener listener : listeners)
      {
          listener.afterPlayerStepped();
      }
  }
  
  /**
   * Adds a player listener to the player.
   * @param listener Player listener object.
   */
  public void addPlayerListener(PlayerListener listener)
  {
      listeners.add(listener);
  }

}