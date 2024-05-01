package labirinth.model.gamestates;

import java.util.ArrayList;
import java.util.List;

/**
 * The GameStateMachine class represents a state machine for managing game states in the labyrinth game.
 */
public class GameStateMachine {
    private GameStateBase currentState; // The current state of the game
    private final List<IGameStateListener> gameStateListeners; // List of listeners for game state changes
    
    /**
     * Constructs a new GameStateMachine object.
     */
    public GameStateMachine() {
        this.gameStateListeners = new ArrayList<>();
        this.currentState = null;
    }
    
    /**
     * Adds a listener for game state changes.
     * 
     * @param listener The listener to add.
     */
    public void addGameStateListener(IGameStateListener listener) {
        gameStateListeners.add(listener);
    }
    
    /**
     * Changes the current state of the game to the specified new state.
     * Notifies all registered listeners about the state change.
     * 
     * @param newState The new state of the game.
     */
    public void changeState(GameStateBase newState) {
        currentState = newState;
        for(IGameStateListener listener : gameStateListeners) {
            listener.onGameStateChanged(currentState);
        }
    }
}

