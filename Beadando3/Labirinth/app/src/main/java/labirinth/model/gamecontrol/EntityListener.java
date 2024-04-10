/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamecontrol;

import labirinth.model.entities.Entity;
import labirinth.model.entities.IEntityListener;
import labirinth.model.map.Block;
import labirinth.model.map.Position;

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
    public void onPositionChanged(Entity entity, Position oldPosition, Position newPosition) {
        Block oldBlock = game.getMap().getBlock(oldPosition);
        Block newBlock = game.getMap().getBlock(newPosition);
        if(oldBlock != null && newBlock != null && oldBlock != newBlock)
        {
            oldBlock.setEntity(null);
            newBlock.setEntity(entity);
            if(entity == game.getPlayerRepresentation().getPlayerEntity() && newBlock == game.getMap().getDragonSpawn())
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
