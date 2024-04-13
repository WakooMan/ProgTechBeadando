/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.map;

/**
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
            
    public Rectangle(Position upperLeftPoint, int width, int height)
    {
        setUpperLeftPoint(upperLeftPoint, width, height);
    }
    
    public Position getUpperLeftPoint()
    {
        return upperLeftPoint;
    }
    
     public Position getUpperRightPoint()
    {
        return upperRightPoint;
    }
     
    public Position getBottomLeftPoint()
    {
        return bottomLeftPoint;
    }
    
     public Position getBottomRightPoint()
    {
        return bottomRightPoint;
    }
     
    public Position getCenter()
    {
      return center;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public Rectangle addX(int x)
    {
        return new Rectangle(upperLeftPoint.addX(x), width, height);
    }
    
    public Rectangle addY(int y)
    {
        return new Rectangle(upperLeftPoint.addY(y), width, height);
    }
    
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
