package labirinth.model.map;

import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.Entity;

/**
 * The Block class represents a block in the labyrinth map.
 */
public class Block {

    private Rectangle rectangle; // The rectangle representing the block
    private final HashMap<Direction, Rectangle> walls; // Map of walls in different directions
    private Entity entity; // The entity (e.g., player or dragon) within the block
    private final Cell cell; // The cell containing the block

    /**
     * Constructs a Block object with the specified upper-left position and cell.
     * 
     * @param upperLeftPoint The upper-left position of the block.
     * @param cell The cell containing the block.
     */
    public Block(Position upperLeftPoint, Cell cell) {
        this.walls = new HashMap<>();
        this.cell = cell;
        this.entity = null;
        setRectangle(upperLeftPoint);
    }

    /**
     * Gets the entity within the block.
     * 
     * @return The entity within the block.
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Gets the cell containing the block.
     * 
     * @return The cell containing the block.
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Sets the entity within the block.
     * 
     * @param entity The entity to set within the block.
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * Gets the size of the block.
     * 
     * @return The size of the block as a Position object.
     */
    public final Position getSize() {
        return MapConfiguration.getInstance().getBlockSize();
    }

    /**
     * Gets the size of the walls.
     * 
     * @return The size of the walls as a Position object.
     */
    public final Position getWallSize() {
        return MapConfiguration.getInstance().getWallSize();
    }

    /**
     * Gets the rectangle representing the block.
     * 
     * @return The rectangle representing the block.
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * Sets the rectangle representing the block with the specified upper-left position.
     * 
     * @param upperLeftPoint The upper-left position to set for the block.
     */
    public final void setRectangle(Position upperLeftPoint) {
        this.rectangle = new Rectangle(upperLeftPoint, getSize().getX(), getSize().getY());
        setWallRectangles();
        if (entity != null) {
            // Calculate entity position based on block's position
            int x = entity.getPosition().getUpperLeftPoint().getX() - rectangle.getUpperLeftPoint().getX();
            int y = entity.getPosition().getUpperLeftPoint().getY() - rectangle.getUpperLeftPoint().getY();
            Position entitySize = MapConfiguration.getInstance().getEntitySize();
            entity.setPosition(new Rectangle(rectangle.getUpperLeftPoint().addX(x).addY(y), entitySize.getX(), entitySize.getY()));
        }
    }

    /**
     * Checks if the given rectangle collides with any wall in the block.
     * 
     * @param rectangle The rectangle to check for collision.
     * @return true if there is a collision with any wall, false otherwise.
     */
    public boolean collidesWithWall(Rectangle rectangle) {
        Direction[] dirs = Direction.values();
        for (Direction dir : dirs) {
            if (collidesWithWall(rectangle, dir)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the wall rectangles for each direction based on block position and size.
     */
    private void setWallRectangles() {
        walls.put(Direction.Up, (cell.getWall(Direction.Up) != null) ? new Rectangle(rectangle.getUpperLeftPoint(), getSize().getX(), getWallSize().getY()) : null);
        walls.put(Direction.Down, (cell.getWall(Direction.Down) != null) ? new Rectangle(rectangle.getBottomLeftPoint().addY(-getWallSize().getY()), getSize().getX(), getWallSize().getY()) : null);
        walls.put(Direction.Right, (cell.getWall(Direction.Right) != null) ? new Rectangle(rectangle.getUpperRightPoint().addX(-getWallSize().getX()), getWallSize().getX(), getSize().getY()) : null);
        walls.put(Direction.Left, (cell.getWall(Direction.Left) != null) ? new Rectangle(rectangle.getUpperLeftPoint(), getWallSize().getX(), getSize().getY()) : null);
    }

    /**
     * Checks if the given rectangle collides with the wall in the specified direction.
     * 
     * @param rect The rectangle to check for collision.
     * @param dir The direction of the wall to check.
     * @return true if there is a collision with the wall, false otherwise.
     */
    private boolean collidesWithWall(Rectangle rect, Direction dir) {
        return rect.collidesWith(walls.get(dir));
    }
}
