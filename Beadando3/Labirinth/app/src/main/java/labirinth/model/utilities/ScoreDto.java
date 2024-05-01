package labirinth.model.utilities;

import java.util.Objects;

/**
 * Data transfer object representing a score.
 * Provides methods for accessing and manipulating player name and score.
 */
public final class ScoreDto {
    
    private String playerName;
    private int score;
    
    /**
     * Constructs a ScoreDto with the specified player name and score.
     *
     * @param playerName The name of the player.
     * @param score The score of the player.
     */
    public ScoreDto(String playerName, int score)
    {
        setPlayerName(playerName);
        setScore(score);
    }
    
    /**
     * Gets the player name.
     *
     * @return The player name.
     */
    public String getPlayerName()
    {
        return playerName;
    }
    
    /**
     * Gets the score.
     *
     * @return The score.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Sets the player name.
     *
     * @param playerName The player name to set.
     */
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    
    /**
     * Sets the score.
     *
     * @param score The score to set.
     */
    public void setScore(int score)
    {
        this.score = score;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;
        ScoreDto scoreDtoObj = (ScoreDto) obj;
        // field comparison
        return playerName.equals(scoreDtoObj.playerName)
                && score == scoreDtoObj.score;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.playerName);
        hash = 53 * hash + this.score;
        return hash;
    }
    
    @Override
    public String toString()
    {
        return playerName + " - " + score;
    }
    
}
