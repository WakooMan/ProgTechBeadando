/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.gamecontrol;

import tictactoe.table.Signal;

/**
 *
 * @author vitya
 */
public class SignalContainer {
    private Signal signal;
    
    public SignalContainer(Signal signal)
    {
        this.signal = signal;
    }
    
    public void setSignal(Signal signal)
    {
        this.signal = signal;
    }
    
    public Signal getSignal()
    {
        return this.signal;
    }
}
