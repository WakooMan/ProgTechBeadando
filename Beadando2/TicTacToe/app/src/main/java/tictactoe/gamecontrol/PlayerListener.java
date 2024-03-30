package tictactoe.gamecontrol;

/**
 * Player listener, which has 2 events: onPlayerTurn, afterPlayerStepped
 */
public interface PlayerListener {
    /**
     * Invoked, when player turn comes.
     */
    void onPlayerTurn();
    
    /**
     * Invoked, after player is stepped.
     */
    void afterPlayerStepped();
}
