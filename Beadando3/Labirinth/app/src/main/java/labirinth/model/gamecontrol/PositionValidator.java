package labirinth.model.gamecontrol;

import java.util.HashSet;
import labirinth.model.entities.Direction;
import labirinth.model.entities.IPositionValidator;
import labirinth.model.map.Block;
import labirinth.model.map.Rectangle;

/**
 * The PositionValidator class is responsible for validating position changes for entities
 * in the game. It implements the IPositionValidator interface.
 */
public class PositionValidator implements IPositionValidator {

    private final Game game; // The game instance for which position validation is performed

    /**
     * Constructs a PositionValidator object with the specified game instance.
     * 
     * @param game The Game instance for which position validation is performed.
     */
    public PositionValidator(Game game) {
        this.game = game;
    }

    /**
     * Checks whether the specified position change is valid for the given direction.
     * 
     * @param direction    The direction of the position change.
     * @param oldPosition  The old position before the change.
     * @param newPosition  The new position after the change.
     * @return             True if the position change is valid, false otherwise.
     */
    @Override
    public boolean isValidPositionChange(Direction direction, Rectangle oldPosition, Rectangle newPosition) {
        // Get the set of blocks at the new position
        HashSet<Block> blocks = game.getMap().getBlocks(newPosition);
        
        // Iterate over each block and check for collision with walls
        for (Block block : blocks) {
            if (block.collidesWithWall(newPosition)) {
                return false; // Collision detected, position change is invalid
            }
        }
        return true; // No collision detected, position change is valid
    }

}

