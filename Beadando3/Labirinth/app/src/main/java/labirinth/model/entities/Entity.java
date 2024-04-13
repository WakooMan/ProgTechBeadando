package labirinth.model.entities;

import java.util.List;
import labirinth.model.map.Block;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.model.map.Rectangle;

public abstract class Entity implements IEntityStepper {

  private final List<IEntityBehavior> behaviors;

  protected StepBehavior stepBehavior;

  public Rectangle position;

  private IPositionValidator positionValidator;

  private IEntityListener entityListener;
  
  private Direction direction;
  
  private boolean m_isMoving;

  protected Entity(List<IEntityBehavior> behaviors) {
      this.behaviors = behaviors;
      direction = Direction.Down;
      m_isMoving = false;
  }

  public boolean isMoving()
  {
      return m_isMoving;
  }
  
  public Direction getDirection()
  {
      return direction;
  }
  
  @Override
  public void step() {
      this.stepBehavior.doBehavior();
      for(IEntityBehavior behavior : behaviors)
      {
          behavior.doBehavior();
      }
  }

  public Rectangle getPosition() {
  return position;
  }
  
  public Position getSize()
  {
      return MapConfiguration.getInstance().getEntitySize();
  }

  public void setPosition(Direction direction) {
    if(direction == null)
    {
        m_isMoving = false;
        return;
    }
    Rectangle newPosition;
    newPosition = switch (direction) {
          case Up -> position.addY(-MapConfiguration.getInstance().getStepSize().getY());
          case Down -> position.addY(+MapConfiguration.getInstance().getStepSize().getY());
          case Right -> position.addX(+MapConfiguration.getInstance().getStepSize().getX());
          case Left -> position.addX(-MapConfiguration.getInstance().getStepSize().getX());
          default -> null;
      };
    if(newPosition != null)
    {
        if(this.positionValidator.isValidPositionChange(direction, position, newPosition))
        {
            Rectangle oldPosition = this.position;
            this.position = newPosition;
            this.entityListener.onPositionChanged(this, oldPosition, newPosition);
        }
        else
        {
            this.stepBehavior.onMoveFailed();
        }
    }
    m_isMoving = true;
    this.direction = direction;
  }
  
  public void setPosition(Rectangle position)
  {
      this.position = position;
  }
  
  public abstract void onEntitySteppedNearby(Entity entity);
  
  public void die() {}

  public void initialize(Block block, IPositionValidator positionValidator, IEntityListener entityListener) {
      Position pos = block.getRectangle().getCenter().addX(-getSize().getX()/2).addY(-getSize().getY()/2);
      this.position = new Rectangle(pos, getSize().getX(), getSize().getY());
      this.positionValidator = positionValidator;
      this.entityListener = entityListener;
  }

}