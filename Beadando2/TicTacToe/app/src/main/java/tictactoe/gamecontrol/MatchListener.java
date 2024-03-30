package tictactoe.gamecontrol;

/**
 * Match listener, which has 3 events: onGameOver, onColumnFilled, onColumnCleared
 */
public interface MatchListener {
    
    /**
     * Event, that is invoked, when game over happens.
     * @param player winner player, null if draw.
     */
    void onGameOver(Player player);
    
    /**
     * Event, that is invoked, when column is filled.
     * @param column column, which is filled.
     */
    void onColumnFilled(int column);
    
    /**
     * Event, that is invoked, when column is cleared.
     * @param column column, which is cleared.
     */
    void onColumnCleared(int column);
}
