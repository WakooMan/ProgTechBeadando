package labirinth.view.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.Timer;
import labirinth.model.gamecontrol.IGameListener;

/**
 * Handles the ticking mechanism for the game, triggering actions at regular intervals.
 */
public class Ticker implements ActionListener, IGameListener {

    private final Timer timer;
    private final int dms;
    private final Consumer<Integer> onTickAction;
    
    /**
     * Constructs a Ticker object with the specified action to be performed on each tick.
     *
     * @param onTickAction The action to be performed on each tick, accepting the time passed since the last tick.
     */
    public Ticker(Consumer<Integer> onTickAction)
    {
        dms = 1000/60;
        timer = new Timer(dms, this);
        this.onTickAction = onTickAction;
    }
    
    /**
     * Starts the ticker.
     */
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
