package labirinth.model.map;

import labirinth.model.entities.Entity;

public abstract class Block {

  private Entity entity;

  protected Block() {
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

  public abstract boolean canStepOn();

}