package tictactoe.table;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a field in the Tic Tac Toe table.
 */
public class Field {

  // List to hold field change listeners
  private final List<FieldChangeListener> listeners;
  // Signal representing the state of the field
  private Signal signal;

  /**
   * Constructs a new instance of the Field class.
   * @param signal The initial signal/state of the field.
   */
  public Field(Signal signal) {
      this.listeners = new ArrayList<>();
      this.signal = signal;
  }

  /**
   * Gets the signal/state of the field.
   * @return The signal/state of the field.
   */
  public Signal getSignal() {
    return signal;
  }

  /**
   * Sets the signal/state of the field.
   * Notifies all registered listeners about the signal change.
   * @param signal The new signal/state of the field.
   */
  public void setSignal(Signal signal) {
      this.signal = signal;
      // Notify all listeners about the signal change
      for(FieldChangeListener listener : listeners) {
          listener.onSignalChanged(this.signal);
      }
  }
  
  /**
   * Adds a listener to the field to be notified about signal changes.
   * @param toAdd The listener to add.
   */
  public void addListener(FieldChangeListener toAdd) {
        listeners.add(toAdd);
    }

}
