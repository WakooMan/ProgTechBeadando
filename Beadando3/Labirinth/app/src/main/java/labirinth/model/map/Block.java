package labirinth.model.map;

import labirinth.model.entities.Direction;
import labirinth.model.entities.Entity;

public class Block {

  private final Position upperLeftPoint;
  private Entity entity;
  private final Cell cell;

  public Block(Position upperLeftPoint, Cell cell) {
      this.upperLeftPoint = upperLeftPoint;
      this.cell = cell;
      this.entity = null;
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

  public int getSize() {
  return MapConfiguration.getInstance().getBlockSize();
  }
  
  public Position getUpperLeftPoint()
  {
      return this.upperLeftPoint;
  }
  
  public Position getUpperRightPoint()
  {
      return this.upperLeftPoint.addX(getSize());
  }
  
  public Position getBottomLeftPoint()
  {
      return this.upperLeftPoint.addY(getSize());
  }
  
  public Position getBottomRightPoint()
  {
      return this.upperLeftPoint.addX(getSize()).addY(getSize());
  }
  
  public Position getCenter()
  {
      return this.upperLeftPoint.addX(getSize() / 2).addY(getSize() / 2);
  }
  
  public boolean canStepTo(Block block, Direction direction)
  {
      return this == block || cell.getWall(direction) == null;
  }

}