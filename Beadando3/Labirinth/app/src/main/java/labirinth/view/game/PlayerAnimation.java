package labirinth.view.game;

import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.PlayerEntity;

/**
 * Manages the animation for the player entity based on its direction.
 */
public class PlayerAnimation extends EntityAnimation {

    /**
     * Constructs a PlayerAnimation object for the specified player entity.
     *
     * @param entity The player entity for which animation is managed.
     */
    public PlayerAnimation(PlayerEntity entity) {
        super(entity, new HashMap<>()
        {{
            put(Direction.Up, AnimationLoader.loadAnimation(entity, "player/idle/up", 150));
            put(Direction.Right, AnimationLoader.loadAnimation(entity, "player/idle/right", 150));
            put(Direction.Left, AnimationLoader.loadAnimation(entity, "player/idle/left", 150));
            put(Direction.Down, AnimationLoader.loadAnimation(entity, "player/idle/down", 150));
        }}, new HashMap<>()
        {
          {
              put(Direction.Up, AnimationLoader.loadAnimation(entity, "player/move/up", 150));
              put(Direction.Right, AnimationLoader.loadAnimation(entity, "player/move/right", 150));
              put(Direction.Left, AnimationLoader.loadAnimation(entity, "player/move/left", 150));
              put(Direction.Down, AnimationLoader.loadAnimation(entity, "player/move/down", 150));
          }
        });
    }
}
