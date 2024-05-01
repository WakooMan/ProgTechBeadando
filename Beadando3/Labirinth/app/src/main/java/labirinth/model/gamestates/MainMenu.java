package labirinth.model.gamestates;

/**
 * The MainMenu class represents the main menu game state in the labyrinth game.
 * It extends the GameStateBase class.
 */
public class MainMenu extends GameStateBase {

    /**
     * Constructs a MainMenu object with the specified GameStateMachine.
     * 
     * @param stateMachine The GameStateMachine controlling the game states.
     */
    public MainMenu(GameStateMachine stateMachine) {
        super(stateMachine);
    }

    /**
     * Starts the game by changing the game state to StartGame.
     */
    public void startGame() {
        this.stateMachine.changeState(new StartGame(stateMachine));
    }
    
    /**
     * Switches to the scores list game state.
     */
    public void scoresList()
    {
        this.stateMachine.changeState(new Scores(stateMachine));
    }

    /**
     * Exits the game.
     */
    public void exitGame() {
        System.exit(0);
    }
}

