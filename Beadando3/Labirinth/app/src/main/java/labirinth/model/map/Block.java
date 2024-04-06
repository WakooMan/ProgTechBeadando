package labirinth.model.map;

import labirinth.model.entities.Entity;

public abstract class Block {

  private final Position upperLeftPoint;
  private Entity entity;

  protected Block(Position upperLeftPoint) {
      this.upperLeftPoint = upperLeftPoint;
      this.entity = null;
  }

  public Entity getEntity() {
  return entity;
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
  
  public Position getCenter()
  {
      return this.upperLeftPoint.addX(getSize() / 2).addY(getSize() / 2);
  }

  public abstract boolean canStepOn();

}