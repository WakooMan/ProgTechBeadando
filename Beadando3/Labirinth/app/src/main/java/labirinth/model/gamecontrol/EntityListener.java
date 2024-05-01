package labirinth.model.gamecontrol;

import labirinth.model.entities.Entity;
import labirinth.model.entities.IEntityListener;
import labirinth.model.map.Block;
import labirinth.model.map.Rectangle;

/**
 * EntityListener is responsible for listening to changes in entity positions and updating the game accordingly.
 * It implements the IEntityListener interface.
 */
public class EntityListener implements IEntityListener {

    private final Game game;
    
    /**
     * Constructs a new EntityListener with the given Game instance.
     * 
     * @param game The Game instance to listen to for entity position changes.
     */
    public EntityListener(Game game)
    {
        this.game = game;
    }
    
    /**
     * Called when an entity's position changes. Updates the game map based on the new position.
     * If the player reaches the win block, triggers a win event.
     * 
     * @param entity The entity whose position changed.
     * @param oldPosition The old position of the entity.
     * @param newPosition The new position of the entity.
     */
    @Override
    public void onPositionChanged(Entity entity, Rectangle oldPosition, Rectangle newPosition) {
        Block oldBlock = game.getMap().getBlock(oldPosition.getCenter());
        Block newBlock = game.getMap().getBlock(newPosition.getCenter());
        if(oldBlock != null && newBlock != null && oldBlock != newBlock)
        {
            oldBlock.setEntity(null);
            newBlock.setEntity(entity);
            if(entity == game.getPlayerRepresentation().getPlayerEntity() && newBlock == game.getMap().getWinBlock())
            {
                game.getPlayerRepresentation().getPlayerEntity().win();
            }
        }
    }
    
}
