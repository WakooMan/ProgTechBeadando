/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamecontrol;

import labirinth.model.entities.Entity;
import labirinth.model.entities.IEntityListener;
import labirinth.model.map.Block;
import labirinth.model.map.Position;
import labirinth.model.map.Rectangle;

/**
 *
 * @author vitya
 */
public class EntityListener implements IEntityListener {

    private final Game game;
    
    public EntityListener(Game game)
    {
        this.game = game;
    }
    
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

            for(Block block : game.getMap().getNeighbors(newBlock))
            {
                if(block.getEntity() != null)
                {
                    block.getEntity().onEntitySteppedNearby(entity);
                }
            }
        }
    }
    
}
