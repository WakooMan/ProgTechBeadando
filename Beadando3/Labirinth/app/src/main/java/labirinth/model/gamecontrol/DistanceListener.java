package labirinth.model.gamecontrol;

import labirinth.model.entities.PlayerEntity;
import labirinth.model.map.Block;
import labirinth.model.map.Map;

/**
 * DistanceListener is responsible for monitoring the distance between the player and other entities in the game.
 * If the player gets too close to certain entities, specific actions are triggered.
 */
public class DistanceListener {
    
    private final Game game;
    
    /**
     * Constructs a new DistanceListener object with the given Game instance.
     * 
     * @param game The Game instance to monitor for distance.
     */
    public DistanceListener(Game game)
    {
        this.game = game;
    }
    
    /**
     * Listens for changes in distance between the player and other entities.
     * If the player gets too close to certain entities, specific actions are triggered.
     */
    public void listen()
    {
        PlayerEntity player = game.getPlayerRepresentation().getPlayerEntity();
        Map map = game.getMap();
        Block playerBlock = map.getBlock(player.getPosition().getCenter());     
        Block dragonBlock = map.getBlock(game.getDragon().getPosition().getCenter());
        if(map.getNeighbors(playerBlock).contains(dragonBlock))
        {
            player.die();
        }
    }
    
}
