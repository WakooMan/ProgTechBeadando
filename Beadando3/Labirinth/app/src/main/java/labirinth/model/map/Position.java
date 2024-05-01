package labirinth.model.map;

/**
 * Represents a position on a 2D grid.
 */
public class Position {

    /**
     * The x-coordinate of the position.
     */
    private final int x;

    /**
     * The y-coordinate of the position.
     */
    private final int y;

    /**
     * Constructs a new Position with the specified coordinates.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new Position that is a copy of the specified Position.
     *
     * @param position The Position to copy.
     */
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    /**
     * Gets the x-coordinate of the position.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the position.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Adds the specified value to the y-coordinate of the position and returns a new Position.
     *
     * @param addition The value to add to the y-coordinate.
     * @return A new Position with the modified y-coordinate.
     */
    public Position addY(int addition) {
        return new Position(x, y + addition);
    }

    /**
     * Adds the specified value to the x-coordinate of the position and returns a new Position.
     *
     * @param addition The value to add to the x-coordinate.
     * @return A new Position with the modified x-coordinate.
     */
    public Position addX(int addition) {
        return new Position(x + addition, y);
    }

    /**
     * Creates a new Position that represents the vector from this Position to the specified Position.
     *
     * @param p2 The end Position of the vector.
     * @return A new Position representing the vector.
     */
    public Position createVector(Position p2) {
        return new Position(x - p2.x, y - p2.y);
    }

    /**
     * Calculates the length of the vector represented by this Position.
     *
     * @return The length of the vector.
     */
    public int getLength() {
        return (int) Math.sqrt((x * x) + (y * y));
    }
}
