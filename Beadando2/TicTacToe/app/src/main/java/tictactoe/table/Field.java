package tictactoe.table;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private final List<FieldChangeListener> listeners;
  private Signal signal;

  public Field(Signal signal) {
      this.listeners = new ArrayList();
      this.signal = signal;
  }

  public Signal getSignal() {
  return signal;
  }

  public void setSignal(Signal signal) {
      this.signal = signal;
      for(FieldChangeListener listener : listeners)
      {
          listener.onSignalChanged(this.signal);
      }
  }
  
  public void addListener(FieldChangeListener toAdd) {
        listeners.add(toAdd);
    }

}