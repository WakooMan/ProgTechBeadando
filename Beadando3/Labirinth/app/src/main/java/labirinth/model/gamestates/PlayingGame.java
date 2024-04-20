/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

import java.sql.SQLException;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.gamecontrol.Game;
import labirinth.model.utilities.IScoreHandler;

/**
 *
 * @author vitya
 */
public class PlayingGame extends GameStateBase {

    
    private final Game game;
    private final IScoreHandler scoreHandler;
    
    public PlayingGame(GameStateMachine stateMachine, String playerName) {
        super(stateMachine);
        game = new Game(playerName);
        scoreHandler = ObjectCompositionUtils.getDefaultScoreHandler();
    }
    
    public Game getGame()
    {
        return game;
    }
    
    public void onGameOver()
    {
        try{
            scoreHandler.addScore(game.getPlayerRepresentation().getName(), game.getPlayerRepresentation().getMapCount());
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        this.stateMachine.changeState(new GameOver(stateMachine, game));
    }
    
}
