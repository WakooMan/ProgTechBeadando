package labirinth.model.entities;

import java.util.ArrayList;
import java.util.List;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IRandomGenerator;

public class DragonStepBehavior extends StepBehavior {

  private final IRandomGenerator randomGenerator;

  private Direction currentDirection;

  public DragonStepBehavior(Dragon dragon) {
      super(dragon);
      randomGenerator = ObjectCompositionUtils.getDefaultRandomGenerator();
      this.currentDirection = getRandomDirection();
  }

  @Override
  protected Direction getDirection() {
      return currentDirection;
  }

  @Override
  protected void onMoveFailed() {
      this.currentDirection = getRandomDirection();
  }
  
  private Direction getRandomDirection()
  {
      List<Direction> directions = new ArrayList<>();
      directions.add(Direction.Up);
      directions.add(Direction.Down);
      directions.add(Direction.Right);
      directions.add(Direction.Left);
      directions.remove(currentDirection);
      return directions.get(randomGenerator.generate(0, directions.size() - 1));
  }

}