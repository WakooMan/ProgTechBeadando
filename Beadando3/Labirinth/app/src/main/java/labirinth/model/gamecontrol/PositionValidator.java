/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamecontrol;

import java.util.HashSet;
import labirinth.model.entities.Direction;
import labirinth.model.entities.IPositionValidator;
import labirinth.model.map.Block;
import labirinth.model.map.Rectangle;

/**
 *
 * @author vitya
 */
public class PositionValidator implements IPositionValidator{

    private final Game game;
    public PositionValidator(Game game)
    {
        this.game = game;
    }
    
    @Override
    public boolean isValidPositionChange(Direction direction, Rectangle oldPosition, Rectangle newPosition) {
        
        HashSet<Block> blocks = game.getMap().getBlocks(newPosition);
        for(Block block : blocks)
        {
            if(block.collidesWithWall(newPosition))
            {
                return false;
            }
        }
        return true;
    }
    
}
