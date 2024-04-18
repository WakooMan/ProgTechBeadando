/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.Timer;
import labirinth.model.gamecontrol.IGameListener;

/**
 *
 * @author vitya
 */
public class Ticker implements ActionListener, IGameListener {

    private final Timer timer;
    private final int dms;
    private final Consumer<Integer> onTickAction;
    
    public Ticker(Consumer<Integer> onTickAction)
    {
        dms = 1000/60;
        timer = new Timer(dms, this);
        this.onTickAction = onTickAction;
    }
    
    
    public void start()
    {
        timer.start();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        onTickAction.accept(dms);
    }

    @Override
    public void onGameOver() {
        timer.stop();
    }

    @Override
    public void onGameStarted() {
    }
    
}
