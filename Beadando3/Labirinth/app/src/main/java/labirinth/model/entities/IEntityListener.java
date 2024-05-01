package labirinth.model.entities;

import labirinth.model.map.Rectangle;

/**
 * IEntityListener is an interface for listening to position changes of entities.
 */
public interface IEntityListener {

    /**
     * Called when the position of an entity changes.
     *
     * @param entity       The entity whose position changed.
     * @param oldPosition  The old position of the entity.
     * @param newPosition  The new position of the entity.
     */
    void onPositionChanged(Entity entity, Rectangle oldPosition, Rectangle newPosition);
}
