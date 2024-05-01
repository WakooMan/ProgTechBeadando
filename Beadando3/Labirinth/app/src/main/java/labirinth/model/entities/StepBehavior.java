package labirinth.model.entities;

/**
 * StepBehavior is an abstract class that represents the behavior of an entity when it steps.
 * It implements the IEntityBehavior interface.
 */
public abstract class StepBehavior implements IEntityBehavior {

    // The entity associated with this behavior
    private final Entity entity;

    /**
     * Constructs a StepBehavior object with the given entity.
     * @param entity The entity associated with this behavior.
     */
    protected StepBehavior(Entity entity) {
        this.entity = entity;
    }

    /**
     * Executes the behavior when the entity steps.
     * This method is abstract and should be implemented by subclasses.
     */
    @Override
    public void doBehavior() {
        // Get the direction of the step and update the entity's position accordingly
        Direction direction = getDirection();
        entity.setPosition(direction);
    }

    /**
     * Retrieves the direction of the step.
     * This method is abstract and should be implemented by subclasses.
     * @return The direction of the step.
     */
    protected abstract Direction getDirection();

    /**
     * Handles the case when the move fails.
     * This method can be overridden by subclasses to provide specific behavior.
     */
    protected void onMoveFailed() {
        // Default implementation does nothing
    }
}
