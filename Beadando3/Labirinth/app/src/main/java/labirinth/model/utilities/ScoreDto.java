/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.utilities;

import java.util.Objects;

/**
 *
 * @author vitya
 */
public final class ScoreDto {
    
    private String playerName;
    private int score;
    
    public ScoreDto(String playerName, int score)
    {
        setPlayerName(playerName);
        setScore(score);
    }
    
    public String getPlayerName()
    {
        return playerName;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    
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
