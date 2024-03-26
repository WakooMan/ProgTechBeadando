package tictactoe.gamecontrol;

import java.util.ArrayList;
import java.util.List;
import tictactoe.table.Signal;

public class Player {

  private final List<PlayerListener> listeners;
    
  private final String name;

  private final Signal signal;

    public List<Match> match;

  public Player(String name, Signal signal) {
      this.listeners = new ArrayList<>();
      this.name = name;
      this.signal = signal;
  }

  public IPlayerCommand doCommand(int column) {
    return placeSignal(column);
  }

  public Signal getSignal() {
    return signal;
  }

  public String getName() {
    return name;
  }

  private PlaceSignalPlayerCommand placeSignal(int columnIndex) {
    return new PlaceSignalPlayerCommand(columnIndex, signal);
  }
  
  public void onPlayerTurn()
  {
      for(PlayerListener listener : listeners)
      {
          listener.onPlayerTurn();
      }
  }
  
  public void afterPlayerStepped()
  {
      for(PlayerListener listener : listeners)
      {
          listener.afterPlayerStepped();
      }
  }
  
  public void addPlayerListener(PlayerListener listener)
  {
      listeners.add(listener);
  }

}