package labirinth.model.gamecontrol;

import labirinth.model.entities.IPlayerEntityListener;

/**
 * The PlayerEntityListener class implements the IPlayerEntityListener interface
 * to handle player entity events such as death and winning.
 */
public class PlayerEntityListener implements IPlayerEntityListener {

    private final Runnable onPlayerDies; // Action to perform when the player dies
    private final Runnable onPlayerWins; // Action to perform when the player wins
    
    /**
     * Constructs a PlayerEntityListener with the specified actions for player death and winning.
     * 
     * @param onPlayerDies The action to perform when the player dies.
     * @param onPlayerWins The action to perform when the player wins.
     */
    public PlayerEntityListener(Runnable onPlayerDies, Runnable onPlayerWins) {
        this.onPlayerDies = onPlayerDies;
        this.onPlayerWins = onPlayerWins;
    }
    
    /**
     * Invoked when the player dies.
     */
    @Override
    public void onPlayerDies() {
        this.onPlayerDies.run();
    }

    /**
     * Invoked when the player wins.
     */
    @Override
    public void onPlayerWins() {
        this.onPlayerWins.run();
    }
}
