/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.map;

import java.util.HashMap;
import labirinth.model.entities.Direction;

/**
 *
 * @author vitya
 */
public class Cell {
    
    private final HashMap<Direction, CellWall> walls;
    private final CellPosition position;
    
    public Cell(CellPosition position)
    {
        this.position = position;
        walls = new HashMap<>();
        addWall(CellWall.Up);
        addWall(CellWall.Down);
        addWall(CellWall.Left);
        addWall(CellWall.Right);
    }
    
    public CellPosition getPosition()
    {
        return position;
    }
    
    public CellWall getWall(Direction direction)
    {
        if(walls.containsKey(direction))
        {
            return walls.get(direction);
        }
        return null;
    }
    
    public void removeWall(Direction direction)
    {
        walls.remove(direction);
    }
    
    private void addWall(CellWall cellWall)
    {
        walls.put(cellWall.getDirection(), cellWall);
    }
    
    
    
    
    
    
    
}
