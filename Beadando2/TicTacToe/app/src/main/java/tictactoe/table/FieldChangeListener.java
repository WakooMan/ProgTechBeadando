package tictactoe.table;

/**
 * Interface for objects that listen for changes in the signal of a field.
 */
public interface FieldChangeListener {
    
    /**
     * Called when the signal of a field changes.
     * @param signal The new signal of the field.
     */
    void onSignalChanged(Signal signal);
}
