package labirinth.model.entities;

import java.util.ArrayList;
import java.util.List;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IRandomGenerator;

/**
 * DragonStepBehavior represents the behavior of a dragon entity when it steps.
 * It extends the StepBehavior class.
 */
public class DragonStepBehavior extends StepBehavior {

    // The random number generator used to determine the direction
    private final IRandomGenerator randomGenerator;

    // The current direction of movement
    private Direction currentDirection;

    /**
     * Constructs a DragonStepBehavior with the given dragon entity.
     * @param dragon The dragon entity associated with this behavior.
     */
    public DragonStepBehavior(Dragon dragon) {
        super(dragon);
        // Get the default random generator
        randomGenerator = ObjectCompositionUtils.getDefaultRandomGenerator();
        // Initialize the current direction to a random direction
        this.currentDirection = getRandomDirection();
    }

    /**
     * Retrieves the direction of the dragon's step.
     * @return The direction of the step.
     */
    @Override
    protected Direction getDirection() {
        return currentDirection;
    }

    /**
     * Handles the case when the dragon's move fails.
     * Generates a new random direction for the dragon.
     */
    @Override
    protected void onMoveFailed() {
        this.currentDirection = getRandomDirection();
    }
  
    /**
     * Generates a random direction for the dragon.
     * @return A random direction.
     */
    private Direction getRandomDirection() {
        List<Direction> directions = new ArrayList<>();
        // Add all directions
        directions.add(Direction.Up);
        directions.add(Direction.Down);
        directions.add(Direction.Right);
        directions.add(Direction.Left);
        // Remove the current direction
        directions.remove(currentDirection);
        // Generate a random index within the range of available directions
        int randomIndex = randomGenerator.generate(0, directions.size() - 1);
        // Return the direction at the random index
        return directions.get(randomIndex);
    }
}
