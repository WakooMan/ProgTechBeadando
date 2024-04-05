package labirinth.model.entities;

import java.util.List;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;

public class Entity implements IEntityStepper {

  private final List<IEntityBehavior> behaviors;

  protected StepBehavior stepBehavior;

  public Position position;

  private IPositionValidator positionValidator;

  private IEntityListener entityListener;

  protected Entity(List<IEntityBehavior> behaviors) {
      this.behaviors = behaviors;
  }

  @Override
  public void step() {
      this.stepBehavior.doBehavior();
      for(IEntityBehavior behavior : behaviors)
      {
          behavior.doBehavior();
      }
  }

  public Position getPosition() {
  return position;
  }

  public void setPosition(Direction direction) {
    Position newPosition;
    newPosition = switch (direction) {
          case Up -> position.addY(-MapConfiguration.getInstance().getStepSize());
          case Down -> position.addY(+MapConfiguration.getInstance().getStepSize());
          case Right -> position.addX(+MapConfiguration.getInstance().getStepSize());
          case Left -> position.addX(-MapConfiguration.getInstance().getStepSize());
          default -> null;
      };
    if(newPosition != null)
    {
        if(this.positionValidator.isValidPosition(newPosition))
        {
            Position oldPosition = this.position;
            this.position = newPosition;
            this.entityListener.onPositionChanged(oldPosition, newPosition);
        }
        else
        {
            this.stepBehavior.onMoveFailed();
        }
    }
  }

  public void initialize(Position position, IPositionValidator positionValidator, IEntityListener entityListener) {
      this.position = position;
      this.positionValidator = positionValidator;
      this.entityListener = entityListener;
  }

}