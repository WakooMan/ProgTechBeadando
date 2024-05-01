package labirinth.model.gamecontrol; 
 
/**
 * The IGameListener interface represents listeners for game events such as game over and game start.
 */
public interface IGameListener {
    
    /**
     * Called when the game is over.
     */
    public void onGameOver();
    
    /**
     * Called when the game is started.
     */
    public void onGameStarted();
}
