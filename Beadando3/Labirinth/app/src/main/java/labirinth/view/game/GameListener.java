package labirinth.view.game;

import labirinth.model.gamecontrol.IGameListener;
import labirinth.model.gamestates.PlayingGame;

/**
 * Listener for game events.
 */
public class GameListener implements IGameListener {
    private final PlayingGame gameState;
    
    /**
     * Constructs a GameListener object for the specified game state.
     *
     * @param gameState The playing game state associated with this listener.
     */
    public GameListener(PlayingGame gameState)
    {
        this.gameState = gameState;
    }
    
    @Override
    public void onGameOver() {
        gameState.onGameOver();
    }

    @Override
    public void onGameStarted() {
    }
}
