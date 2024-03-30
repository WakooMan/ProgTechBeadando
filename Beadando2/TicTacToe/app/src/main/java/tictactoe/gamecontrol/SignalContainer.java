package tictactoe.gamecontrol;

import tictactoe.table.Signal;

/**
 * A wrapper class for signal.
 * Used only in TableObserver class.
 */
public class SignalContainer {
    private Signal signal;
    
    /**
     * Constructor.
     * @param signal Signal. 
     */
    public SignalContainer(Signal signal)
    {
        this.signal = signal;
    }
    
    /**
     * Sets the signal.
     * @param signal New signal.
     */
    public void setSignal(Signal signal)
    {
        this.signal = signal;
    }
    
    /**
     * Gets the signal.
     * @return The signal.
     */
    public Signal getSignal()
    {
        return this.signal;
    }
}
