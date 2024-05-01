package labirinth.model.map;

import labirinth.model.entities.Direction;

/**
 * The CellWall class represents a wall in a labyrinth cell.
 */
public class CellWall {
    
    // Static instances representing walls in different directions
    public static final CellWall Up = new CellWall(Direction.Up);
    public static final CellWall Down = new CellWall(Direction.Down);
    public static final CellWall Left = new CellWall(Direction.Left);
    public static final CellWall Right = new CellWall(Direction.Right);
    
    static {
        // Set the opposite walls for each direction
        Up.setOpposite(Down);
        Down.setOpposite(Up);
        Right.setOpposite(Left);
        Left.setOpposite(Right);
    }
    
    private CellWall opposite; // Opposite wall
    private final Direction direction; // Direction of the wall
    
    // Private constructor
    private CellWall(Direction direction) {
        this.direction = direction;
    }
    
    /**
     * Gets the opposite wall.
     * 
     * @return The opposite wall.
     */
    public CellWall getOpposite() {
        return opposite;
    }
    
    // Private method to set the opposite wall
    private void setOpposite(CellWall opposite) {
        this.opposite = opposite;
    }
    
    /**
     * Gets the direction of the wall.
     * 
     * @return The direction of the wall.
     */
    public Direction getDirection() {
        return direction;
    }
}
