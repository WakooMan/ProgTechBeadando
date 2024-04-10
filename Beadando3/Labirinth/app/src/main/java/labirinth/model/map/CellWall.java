/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.map;

import labirinth.model.entities.Direction;

/**
 *
 * @author vitya
 */
public class CellWall {
    
    public static final CellWall Up = new CellWall(Direction.Up);
    public static final CellWall Down = new CellWall(Direction.Down);
    public static final CellWall Left = new CellWall(Direction.Left);
    public static final CellWall Right = new CellWall(Direction.Right);
    
    static 
    {
        Up.setOpposite(Down);
        Down.setOpposite(Up);
        Right.setOpposite(Left);
        Left.setOpposite(Right);
    }
    
    private CellWall opposite;
    private final Direction direction;
    
    private CellWall(Direction direction)
    {
        this.direction = direction;
    }
    
    public CellWall getOpposite()
    {
        return opposite;
    }
    
    private void setOpposite(CellWall opposite)
    {
        this.opposite = opposite;
    }
    
    public Direction getDirection()
    {
        return direction;
    }
    
}
