package labirinth.view.game;

import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.Dragon;

/**
 * Represents the animation for a dragon entity.
 */
public class DragonAnimation extends EntityAnimation {
    
    /**
     * Constructs a DragonAnimation object for the specified dragon entity.
     *
     * @param entity The dragon entity associated with this animation.
     */
    public DragonAnimation(Dragon entity) {
        super(entity, new HashMap<>() {{
                put(Direction.Up, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
                put(Direction.Right, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
                put(Direction.Left, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
                put(Direction.Down, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
            }},
            new HashMap<>() {{
                put(Direction.Up, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
                put(Direction.Right, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
                put(Direction.Left, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
                put(Direction.Down, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
            }}
        );
    }
}
