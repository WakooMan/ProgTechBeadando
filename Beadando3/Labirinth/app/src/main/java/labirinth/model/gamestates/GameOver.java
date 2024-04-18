/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

import labirinth.model.gamecontrol.Game;

/**
 *
 * @author vitya
 */
public class GameOver extends GameStateBase {
    
    private final Game game; 
    
    public GameOver(GameStateMachine stateMachine, Game game) {
        super(stateMachine);
        this.game = game;
    }
    
    public String getGameOverMessage()
    {
        return "Game is over!";
    }
    
    public String getCompletedMapsMessage()
    {
        return "Completed maps: " + this.game.getPlayerRepresentation().getMapCount();
    }
    
    public Game getGame()
    {
        return game;
    }
    
    public void GoToMenu()
    {
        this.stateMachine.changeState(new MainMenu(stateMachine));
    }
    
    public void GoToScores()
    {
        this.stateMachine.changeState(new Scores(stateMachine));
    }
    
}
