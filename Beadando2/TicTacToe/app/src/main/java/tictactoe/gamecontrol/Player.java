package tictactoe.gamecontrol;

import java.util.List;
import tictactoe.table.Signal;

public class Player {

  private final String name;

  private final Signal signal;

    public List<Match> match;

  public Player(String name, Signal signal) {
      this.name = name;
      this.signal = signal;
  }

  public IPlayerCommand doCommand() {
    return placeSignal(1);
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

}