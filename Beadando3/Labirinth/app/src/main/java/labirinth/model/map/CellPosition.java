package labirinth.model.map;

import labirinth.model.entities.Direction;

/**
 * The CellPosition class represents the position of a cell in the labyrinth map.
 */
public class CellPosition {
    
    private final int i; // Row index
    private final int j; // Column index

    /**
     * Constructs a CellPosition object with the specified row and column indices.
     * 
     * @param i The row index.
     * @param j The column index.
     */
    public CellPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Gets the row index.
     * 
     * @return The row index.
     */
    public int getI() {
        return i;
    }

    /**
     * Gets the column index.
     * 
     * @return The column index.
     */
    public int getJ() {
        return j;
    }

    /**
     * Adds the specified value to the column index and returns a new CellPosition object.
     * 
     * @param addition The value to add to the column index.
     * @return A new CellPosition object with the updated column index.
     */
    public CellPosition addJ(int addition) {
        return new CellPosition(i, j + addition);
    }

    /**
     * Adds the specified value to the row index and returns a new CellPosition object.
     * 
     * @param addition The value to add to the row index.
     * @return A new CellPosition object with the updated row index.
     */
    public CellPosition addI(int addition) {
        return new CellPosition(i + addition, j);
    }
  
    /**
     * Gets the CellPosition object in the specified direction from this position.
     * 
     * @param direction The direction.
     * @return The CellPosition object in the specified direction, or null if the direction is invalid.
     */
    public CellPosition getCellPosition(Direction direction) {
        return switch (direction) {
            case Up -> addI(-1);
            case Down -> addI(1);
            case Right -> addJ(1);
            case Left -> addJ(-1);
            default -> null;
        };
    }
  
    /**
     * Calculates the Euclidean distance between this position and another position.
     * 
     * @param p2 The other position.
     * @return The Euclidean distance between this position and p2.
     */
    public int getLengthBetween(CellPosition p2) {
        int a = i - p2.i;
        int b = j - p2.j;
        return (int) Math.sqrt((a * a) + (b * b));
    }
}
