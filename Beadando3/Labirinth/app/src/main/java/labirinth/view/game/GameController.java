package labirinth.view.game;

import labirinth.model.gamecontrol.Game;
import labirinth.model.gamestates.PlayingGame;

/**
 * Controller for managing the game logic and rendering.
 */
public class GameController{
    
    private final MapRenderer mapRenderer;
    private final GameListener gameListener;
    private final Ticker ticker;
    private final Game game;
    
    /**
     * Constructs a GameController object for the specified game state.
     *
     * @param gameState The playing game state associated with this controller.
     */
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
    
    /**
     * Starts the game and the ticker.
     */
    public void startGame()
    {
        game.startGame();
        ticker.start();
    }
    
    /**
     * Gets the map renderer associated with this controller.
     *
     * @return The map renderer.
     */
    public MapRenderer getMapRenderer()
    {
        return mapRenderer;
    }
    
}
