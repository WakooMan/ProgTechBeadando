package labirinth.model.gamestates;

import java.sql.SQLException;
import java.util.List;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IScoreHandler;
import labirinth.model.utilities.ScoreDto;

/**
 * The Scores class represents the game state when viewing scores.
 * It extends the GameStateBase class.
 */
public class Scores extends GameStateBase {

    private final IScoreHandler scoreHandler; // The score handler for managing scores

    /**
     * Constructs a Scores object with the specified GameStateMachine.
     * 
     * @param stateMachine The GameStateMachine controlling the game states.
     */
    public Scores(GameStateMachine stateMachine) {
        super(stateMachine);
        scoreHandler = ObjectCompositionUtils.getDefaultScoreHandler(); // Get the default score handler
    }
    
    /**
     * Switches the game state back to the main menu.
     */
    public void BackToMenu() {
        this.stateMachine.changeState(new MainMenu(stateMachine));
    }
    
    /**
     * Retrieves the list of scores.
     * 
     * @return The list of scores.
     * @throws SQLException if an SQL exception occurs.
     */
    public List<ScoreDto> getScores() throws SQLException {
        return scoreHandler.getScores(); // Retrieve scores using the score handler
    }
    
}

