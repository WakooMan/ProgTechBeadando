/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamecontrol;

import labirinth.model.entities.Direction;
import labirinth.model.entities.IPositionValidator;
import labirinth.model.map.Block;
import labirinth.model.map.Position;

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
    public boolean isValidPositionChange(Direction direction, Position oldPosition, Position newPosition) {
        Block fromBlock = game.getMap().getBlock(oldPosition);
        Block toBlock = game.getMap().getBlock(newPosition);
        if(fromBlock == null || toBlock == null)
        {
            return false;
        }
        if(fromBlock == toBlock && fromBlock.getCell().getWall(direction) != null)
        {
            return fromBlock.canStepTo(newPosition);
        }
        return fromBlock.canStepTo(toBlock, direction) && toBlock.canStepTo(newPosition);
    }
    
}
