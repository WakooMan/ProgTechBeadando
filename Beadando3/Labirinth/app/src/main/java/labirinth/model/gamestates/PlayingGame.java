package labirinth.model.gamestates;

import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.gamecontrol.Game;
import labirinth.model.utilities.IScoreHandler;

/**
 * The PlayingGame class represents the game state when the player is actively playing the game.
 * It extends the GameStateBase class.
 */
public class PlayingGame extends GameStateBase {

    private final Game game; // The current game being played
    private final IScoreHandler scoreHandler; // The score handler for managing player scores

    /**
     * Constructs a PlayingGame object with the specified GameStateMachine and player name.
     * 
     * @param stateMachine The GameStateMachine controlling the game states.
     * @param playerName The name of the player.
     */
    public PlayingGame(GameStateMachine stateMachine, String playerName) {
        super(stateMachine);
        game = new Game(playerName); // Initialize the game with the player name
        scoreHandler = ObjectCompositionUtils.getDefaultScoreHandler(); // Get the default score handler
    }
    
    /**
     * Retrieves the current game being played.
     * 
     * @return The current game being played.
     */
    public Game getGame() {
        return game;
    }
    
    /**
     * Handles the game over event.
     * It adds the player's score to the score handler and switches the game state to GameOver.
     */
    public void onGameOver() {
        try {
            scoreHandler.addScore(game.getPlayerRepresentation().getName(), game.getPlayerRepresentation().getMapCount());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            // Display a warning message if an error occurs during saving scores
            JOptionPane optionPane = new JOptionPane("Error happened during saving scores!", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning!");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        // Change the game state to GameOver
        this.stateMachine.changeState(new GameOver(stateMachine, game));
    }    
}

