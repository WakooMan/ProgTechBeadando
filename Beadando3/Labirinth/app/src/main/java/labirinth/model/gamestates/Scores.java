/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

import java.sql.SQLException;
import java.util.List;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IScoreHandler;
import labirinth.model.utilities.ScoreDto;

/**
 *
 * @author vitya
 */
public class Scores extends GameStateBase{
    
    private final IScoreHandler scoreHandler;
    
    public Scores(GameStateMachine stateMachine) {
        super(stateMachine);
        scoreHandler = ObjectCompositionUtils.getDefaultScoreHandler();
    }
    
    public void BackToMenu()
    {
        this.stateMachine.changeState(new MainMenu(stateMachine));
    }
    
    public List<ScoreDto> getScores() throws SQLException
    {
        return scoreHandler.getScores();
    }
    
}
