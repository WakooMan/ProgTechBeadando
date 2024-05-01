package labirinth.model.gamestates;

/**
 * The GameStateBase class is an abstract base class for game states in the labyrinth game.
 */
public abstract class GameStateBase {
    protected final GameStateMachine stateMachine; // The state machine managing game states
    
    /**
     * Constructs a GameStateBase object with the specified state machine.
     * 
     * @param stateMachine The GameStateMachine managing the game states.
     */
    protected GameStateBase(GameStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
}

