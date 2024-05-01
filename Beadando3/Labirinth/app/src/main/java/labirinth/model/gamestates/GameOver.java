package labirinth.model.gamestates;

import labirinth.model.gamecontrol.Game;

/**
 * The GameOver class represents the game state when the game is over. It extends the
 * GameStateBase class.
 */
public class GameOver extends GameStateBase {

    private final Game game; // The game instance associated with the game over state

    /**
     * Constructs a GameOver object with the specified state machine and game instance.
     * 
     * @param stateMachine The GameStateMachine managing the game states.
     * @param game         The Game instance associated with the game over state.
     */
    public GameOver(GameStateMachine stateMachine, Game game) {
        super(stateMachine);
        this.game = game;
    }

    /**
     * Retrieves the message indicating that the game is over.
     * 
     * @return The message indicating that the game is over.
     */
    public String getGameOverMessage() {
        return "Game is over!";
    }

    /**
     * Retrieves the message indicating the number of completed maps.
     * 
     * @return The message indicating the number of completed maps.
     */
    public String getCompletedMapsMessage() {
        return "Completed maps: " + this.game.getPlayerRepresentation().getMapCount();
    }

    /**
     * Retrieves the game instance associated with the game over state.
     * 
     * @return The game instance associated with the game over state.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Changes the game state to the main menu state.
     */
    public void goToMenu() {
        this.stateMachine.changeState(new MainMenu(stateMachine));
    }

    /**
     * Changes the game state to the scores state.
     */
    public void goToScores() {
        this.stateMachine.changeState(new Scores(stateMachine));
    }
    
}

