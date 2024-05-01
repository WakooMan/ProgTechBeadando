package labirinth.model.map;

import java.util.HashMap;
import labirinth.model.entities.Direction;

/**
 * The Cell class represents a cell in the labyrinth map.
 */
public class Cell {
    
    private final HashMap<Direction, CellWall> walls; // Map of walls in different directions
    private final CellPosition position; // Position of the cell
    
    /**
     * Constructs a Cell object with the specified position.
     * Initializes the cell with walls in all directions.
     * 
     * @param position The position of the cell.
     */
    public Cell(CellPosition position) {
        this.position = position;
        walls = new HashMap<>();
        addWall(CellWall.Up);
        addWall(CellWall.Down);
        addWall(CellWall.Left);
        addWall(CellWall.Right);
    }
    
    /**
     * Gets the position of the cell.
     * 
     * @return The position of the cell.
     */
    public CellPosition getPosition() {
        return position;
    }
    
    /**
     * Gets the wall in the specified direction.
     * 
     * @param direction The direction of the wall.
     * @return The wall in the specified direction, or null if no wall exists.
     */
    public CellWall getWall(Direction direction) {
        if (walls.containsKey(direction)) {
            return walls.get(direction);
        }
        return null;
    }
    
    /**
     * Removes the wall in the specified direction.
     * 
     * @param direction The direction of the wall to remove.
     */
    public void removeWall(Direction direction) {
        walls.remove(direction);
    }
    
    /**
     * Adds a wall to the cell in the specified direction.
     * 
     * @param cellWall The wall to add.
     */
    private void addWall(CellWall cellWall) {
        walls.put(cellWall.getDirection(), cellWall);
    }
}

