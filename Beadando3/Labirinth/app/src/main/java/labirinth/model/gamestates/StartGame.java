package labirinth.model.gamestates;

/**
 * The StartGame class represents the game state when starting a new game.
 * It extends the GameStateBase class.
 */
public class StartGame extends GameStateBase {

    /**
     * Constructs a StartGame object with the specified GameStateMachine.
     * 
     * @param stateMachine The GameStateMachine controlling the game states.
     */
    public StartGame(GameStateMachine stateMachine) {
        super(stateMachine);
    }

    /**
     * Initiates the start of a new game with the given player name.
     * 
     * @param playerName The name of the player.
     */
    public void startGame(String playerName) {
        this.stateMachine.changeState(new PlayingGame(stateMachine, playerName)); // Start a new game
    }

    /**
     * Switches the game state back to the main menu.
     */
    public void backToMainMenu() {
        this.stateMachine.changeState(new MainMenu(stateMachine)); // Return to the main menu
    }
    
}

