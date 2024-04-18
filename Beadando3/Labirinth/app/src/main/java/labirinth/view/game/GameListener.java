/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import labirinth.model.gamecontrol.IGameListener;
import labirinth.model.gamestates.PlayingGame;

/**
 *
 * @author vitya
 */
public class GameListener implements IGameListener {
    private final PlayingGame gameState;
    
    public GameListener(PlayingGame gameState)
    {
        this.gameState = gameState;
    }
    
    @Override
    public void onGameOver() {
        gameState.onGameOver();
    }

    @Override
    public void onGameStarted() {
    }
}
