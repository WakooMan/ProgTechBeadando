package labirinth.model.entities;

import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IKeyHandler;

/**
 * PlayerStepBehavior represents the behavior of a player entity when it steps.
 * It extends the StepBehavior class.
 */
public class PlayerStepBehavior extends StepBehavior {

    // The key handler used to determine the player's movement direction
    private final IKeyHandler keyHandler;

    /**
     * Constructs a PlayerStepBehavior with the given player entity.
     * @param player The player entity associated with this behavior.
     */
    public PlayerStepBehavior(PlayerEntity player) {
        super(player);
        // Get the default key handler
        keyHandler = ObjectCompositionUtils.getDefaultKeyHandler();
    }
  
    /**
     * Retrieves the direction of the player's step based on the pressed keys.
     * @return The direction of the step.
     */
    @Override
    protected Direction getDirection() {
        if (keyHandler.isUpKeyDown()) {
            return Direction.Up;
        }
        if (keyHandler.isDownKeyDown()) {
            return Direction.Down;
        }
        if (keyHandler.isRightKeyDown()) {
            return Direction.Right;
        }
        if (keyHandler.isLeftKeyDown()) {
            return Direction.Left;
        }
        return null;
    }
}
