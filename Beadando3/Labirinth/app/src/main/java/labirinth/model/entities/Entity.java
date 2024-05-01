package labirinth.model.entities;

import java.util.List;
import labirinth.model.map.Block;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.model.map.Rectangle;

/**
 * Abstract class representing an entity in the labyrinth.
 * Entities are objects that can move within the labyrinth.
 */
public abstract class Entity implements IEntityStepper {

    // List of behaviors associated with this entity
    private final List<IEntityBehavior> behaviors;

    // Behavior for stepping
    protected StepBehavior stepBehavior;

    // Position of the entity
    public Rectangle position;

    // Validator for validating position changes
    private IPositionValidator positionValidator;

    // Listener for entity events
    private IEntityListener entityListener;
    
    // Direction in which the entity is facing
    private Direction direction;
    
    // Flag indicating if the entity is currently moving
    private boolean m_isMoving;

    /**
     * Constructs an Entity object with given behaviors.
     * Initializes the direction as Down and sets m_isMoving to false.
     * @param behaviors List of behaviors associated with this entity.
     */
    protected Entity(List<IEntityBehavior> behaviors) {
        this.behaviors = behaviors;
        direction = Direction.Down;
        m_isMoving = false;
    }

    /**
     * Checks if the entity is currently moving.
     * @return True if the entity is moving, false otherwise.
     */
    public boolean isMoving() {
        return m_isMoving;
    }
    
    /**
     * Gets the direction in which the entity is facing.
     * @return The direction of the entity.
     */
    public Direction getDirection() {
        return direction;
    }
    
    @Override
    public void step() {
        // Perform step behavior
        this.stepBehavior.doBehavior();
        
        // Perform other behaviors associated with the entity
        for(IEntityBehavior behavior : behaviors) {
            behavior.doBehavior();
        }
    }

    /**
     * Gets the position of the entity.
     * @return The position of the entity.
     */
    public Rectangle getPosition() {
        return position;
    }
    
    /**
     * Gets the size of the entity.
     * @return The size of the entity.
     */
    public Position getSize() {
        return MapConfiguration.getInstance().getEntitySize();
    }

    /**
     * Sets the position of the entity in a specified direction.
     * @param direction The direction in which to move the entity.
     */
    public void setPosition(Direction direction) {
        if(direction == null) {
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
        if(newPosition != null) {
            if(this.positionValidator.isValidPositionChange(direction, position, newPosition)) {
                Rectangle oldPosition = this.position;
                this.position = newPosition;
                this.entityListener.onPositionChanged(this, oldPosition, newPosition);
            } else {
                this.stepBehavior.onMoveFailed();
            }
        }
        m_isMoving = true;
        this.direction = direction;
    }
    
    /**
     * Sets the position of the entity.
     * @param position The new position of the entity.
     */
    public void setPosition(Rectangle position) {
        this.position = position;
    }
    
    /**
     * Handles the death of the entity.
     */
    public void die() {}

    /**
     * Initializes the entity with a block, position validator, and entity listener.
     * @param block The block containing the entity.
     * @param positionValidator The validator for validating position changes.
     * @param entityListener The listener for entity events.
     */
    public void initialize(Block block, IPositionValidator positionValidator, IEntityListener entityListener) {
        Position pos = block.getRectangle().getCenter().addX(-getSize().getX()/2).addY(-getSize().getY()/2);
        this.position = new Rectangle(pos, getSize().getX(), getSize().getY());
        this.positionValidator = positionValidator;
        this.entityListener = entityListener;
    }

}
