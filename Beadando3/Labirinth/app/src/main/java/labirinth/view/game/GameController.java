/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import labirinth.model.gamecontrol.Game;
import labirinth.model.gamestates.PlayingGame;

/**
 *
 * @author vitya
 */
public class GameController{
    
    private final MapRenderer mapRenderer;
    private final GameListener gameListener;
    private final Ticker ticker;
    private final Game game;
    
    public GameController(PlayingGame gameState)
    {
        game = gameState.getGame();
        gameListener = new GameListener(gameState);
        mapRenderer = new MapRenderer(game);
        ticker = new Ticker((dms) -> 
        {
            game.onTick();
            mapRenderer.onTick(dms);
        });
        game.addGameListener(ticker);
        game.addGameListener(mapRenderer);
        game.addGameListener(gameListener);
    }
    
    public void startGame()
    {
        game.startGame();
        ticker.start();
    }
    
    public MapRenderer getMapRenderer()
    {
        return mapRenderer;
    }
    
}
