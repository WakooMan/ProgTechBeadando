package labirinth.model.entities;

import labirinth.model.map.Rectangle;

/**
 * IPositionValidator is an interface for validating position changes of entities.
 */
public interface IPositionValidator {

    /**
     * Checks if a position change is valid for an entity.
     * @param direction The direction of the position change.
     * @param oldPosition The old position of the entity.
     * @param newPosition The new position of the entity.
     * @return True if the position change is valid, false otherwise.
     */
    boolean isValidPositionChange(Direction direction, Rectangle oldPosition, Rectangle newPosition);

}
