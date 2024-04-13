package labirinth.model.map;

import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.Entity;

public class Block {

  private Rectangle rectangle;
  private final HashMap<Direction,Rectangle> walls;
  private Entity entity;
  private final Cell cell;

  public Block(Position upperLeftPoint, Cell cell) {
      this.walls = new HashMap<>();
      this.cell = cell;
      this.entity = null;
      setRectangle(upperLeftPoint);
  }

  public Entity getEntity() {
  return entity;
  }
  
  public Cell getCell() {
  return cell;
  }
  
  public void setEntity(Entity entity) {
  this.entity = entity;
  }

  public final Position getSize() {
  return MapConfiguration.getInstance().getBlockSize();
  }
  
  public final Position getWallSize() {
  return MapConfiguration.getInstance().getWallSize();
  }
  
  public Rectangle getRectangle()
  {
      return rectangle;
  }
  
  public final void setRectangle(Position upperLeftPoint)
  {
      Double ratioX = null;
      Double ratioY = null;
      if(this.entity != null)
      {
          ratioX = (double)(entity.getPosition().getUpperLeftPoint().getX() - rectangle.getUpperLeftPoint().getX()) / (double)(rectangle.getBottomRightPoint().getX() - rectangle.getUpperLeftPoint().getX());
          ratioY = (double)(entity.getPosition().getUpperLeftPoint().getY() - rectangle.getUpperLeftPoint().getY()) / (double)(rectangle.getBottomRightPoint().getY() - rectangle.getUpperLeftPoint().getY());
      }
      this.rectangle = new Rectangle(upperLeftPoint, getSize().getX(), getSize().getY());
      setWallRectangles();
      if(entity != null)
      {
        int x = (int)((rectangle.getBottomRightPoint().getX() - rectangle.getUpperLeftPoint().getX()) * ratioX);
        int y = (int)((rectangle.getBottomRightPoint().getY() - rectangle.getUpperLeftPoint().getY()) * ratioY);
        Position entitySize = MapConfiguration.getInstance().getEntitySize();
        entity.setPosition(new Rectangle(rectangle.getUpperLeftPoint().addX(x).addY(y), entitySize.getX(), entitySize.getY()));
      }
  }
  
  public boolean collidesWithWall(Rectangle rectangle)
  {
      Direction[] dirs = Direction.values();
      for(Direction dir : dirs)
      {
          if(collidesWithWall(rectangle, dir))
          {
              return true;
          }
      }
      return false;
  }

  private void setWallRectangles()
  {
      walls.put(Direction.Up,(cell.getWall(Direction.Up) != null) ? new Rectangle(new Position(rectangle.getUpperLeftPoint()),getSize().getX(),getWallSize().getY()) : null);
      walls.put(Direction.Down,(cell.getWall(Direction.Down) != null) ? new Rectangle(new Position(rectangle.getBottomLeftPoint().addY(-getWallSize().getY())),getSize().getX(),getWallSize().getY()) : null);
      walls.put(Direction.Right,(cell.getWall(Direction.Right) != null) ? new Rectangle(new Position(rectangle.getUpperRightPoint().addX(-getWallSize().getX())),getWallSize().getX(),getSize().getY()) : null);
      walls.put(Direction.Left,(cell.getWall(Direction.Left) != null) ? new Rectangle(new Position(rectangle.getUpperLeftPoint()),getWallSize().getX(),getSize().getY()) : null);
  }
  
  private boolean collidesWithWall(Rectangle rect, Direction dir)
  {
      return rect.collidesWith(walls.get(dir));
  }
  
}