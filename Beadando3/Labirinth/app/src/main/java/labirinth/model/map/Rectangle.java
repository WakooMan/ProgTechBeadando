package labirinth.model.map;

/**
 * Represents a rectangle defined by its upper-left point, width, and height.
 * Provides methods for basic rectangle operations.
 *
 * @author vitya
 */
public class Rectangle {
    private Position upperLeftPoint;
    private Position upperRightPoint;
    private Position bottomLeftPoint;
    private Position bottomRightPoint;
    private Position center;
    private int width;
    private int height;
            
    /**
     * Constructs a Rectangle with the specified upper-left point, width, and height.
     *
     * @param upperLeftPoint The upper-left point of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Position upperLeftPoint, int width, int height)
    {
        setUpperLeftPoint(upperLeftPoint, width, height);
    }
    
    // Getters for rectangle properties
    
    /**
     * Gets the upper-left point of the rectangle.
     *
     * @return The upper-left point.
     */
    public Position getUpperLeftPoint()
    {
        return upperLeftPoint;
    }
    
    /**
     * Gets the upper-right point of the rectangle.
     *
     * @return The upper-right point.
     */
    public Position getUpperRightPoint()
    {
        return upperRightPoint;
    }
    
    /**
     * Gets the bottom-left point of the rectangle.
     *
     * @return The bottom-left point.
     */
    public Position getBottomLeftPoint()
    {
        return bottomLeftPoint;
    }
    
    /**
     * Gets the bottom-right point of the rectangle.
     *
     * @return The bottom-right point.
     */
    public Position getBottomRightPoint()
    {
        return bottomRightPoint;
    }
    
    /**
     * Gets the center point of the rectangle.
     *
     * @return The center point.
     */
    public Position getCenter()
    {
      return center;
    }
    
    /**
     * Gets the width of the rectangle.
     *
     * @return The width.
     */
    public int getWidth()
    {
        return width;
    }
    
    /**
     * Gets the height of the rectangle.
     *
     * @return The height.
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Returns a new Rectangle by adding the specified value to the x-coordinate of the upper-left point.
     *
     * @param x The value to add to the x-coordinate.
     * @return A new Rectangle with the modified position.
     */
    public Rectangle addX(int x)
    {
        return new Rectangle(upperLeftPoint.addX(x), width, height);
    }
    
    /**
     * Returns a new Rectangle by adding the specified value to the y-coordinate of the upper-left point.
     *
     * @param y The value to add to the y-coordinate.
     * @return A new Rectangle with the modified position.
     */
    public Rectangle addY(int y)
    {
        return new Rectangle(upperLeftPoint.addY(y), width, height);
    }
    
    /**
     * Sets the upper-left point, width, and height of the rectangle.
     *
     * @param upperLeftPoint The upper-left point of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public final void setUpperLeftPoint(Position upperLeftPoint, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.upperLeftPoint = upperLeftPoint;
        this.upperRightPoint = upperLeftPoint.addX(width);
        this.bottomLeftPoint = upperLeftPoint.addY(height);
        this.bottomRightPoint = bottomLeftPoint.addX(width);
        this.center = upperLeftPoint.addX(width/2).addY(height/2);
    }
    
    /**
     * Checks if this rectangle collides with the specified rectangle.
     *
     * @param rect The rectangle to check collision with.
     * @return True if this rectangle collides with the specified rectangle, false otherwise.
     */
    public boolean collidesWith(Rectangle rect)
    {
        if(rect == null)
        {
            return false;
        }
        return upperLeftPoint.getX() < rect.getBottomRightPoint().getX() && 
                bottomRightPoint.getX() > rect.getUpperLeftPoint().getX() &&
                upperLeftPoint.getY() < rect.getBottomRightPoint().getY() &&
                bottomRightPoint.getY() > rect.getUpperLeftPoint().getY();
    }
}
