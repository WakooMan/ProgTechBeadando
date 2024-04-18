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
public class PlayingGame extends GameStateBase {

    
    private final Game game;
    
    public PlayingGame(GameStateMachine stateMachine, String playerName) {
        super(stateMachine);
        game = new Game(playerName);
    }
    
    public Game getGame()
    {
        return game;
    }
    
    public void onGameOver()
    {
        this.stateMachine.changeState(new GameOver(stateMachine, game));
    }
    
}
