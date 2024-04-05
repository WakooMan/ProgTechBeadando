package labirinth.model.entities;

/*
 */
public abstract class StepBehavior implements IEntityBehavior {

  private final Entity entity;

  @Override
  public void doBehavior() {
      Direction direction = getDirection();
      entity.setPosition(direction);
  }

  protected abstract Direction getDirection();

  protected StepBehavior(Entity entity) {
      this.entity = entity;
  }

  protected void onMoveFailed() {
  }

}