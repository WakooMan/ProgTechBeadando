package labirinth.model.utilities;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for handling scores.
 */
public interface IScoreHandler {

    /**
     * Retrieves a list of scores.
     *
     * @return A list of ScoreDto objects representing scores.
     * @throws SQLException if a database access error occurs.
     */
    List<ScoreDto> getScores() throws SQLException;

    /**
     * Adds a new score for the specified player.
     *
     * @param playerName The name of the player.
     * @param score The score to add.
     * @throws SQLException if a database access error occurs.
     */
    void addScore(String playerName, int score) throws SQLException;
}
