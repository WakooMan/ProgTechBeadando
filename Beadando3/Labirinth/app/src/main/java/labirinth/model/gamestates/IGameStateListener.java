package labirinth.model.gamestates;

/**
 * The IGameStateListener interface defines a listener for game state changes in the labyrinth game.
 */
public interface IGameStateListener {
    
    /**
     * Called when the game state changes.
     * 
     * @param gameState The new game state.
     */
    void onGameStateChanged(GameStateBase gameState);
}

