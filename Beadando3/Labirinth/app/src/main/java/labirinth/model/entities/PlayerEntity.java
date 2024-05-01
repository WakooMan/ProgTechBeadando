package labirinth.model.entities;

import java.util.ArrayList;

/**
 * Represents the player entity in the labyrinth.
 * The player entity is controlled by the user and can move within the labyrinth.
 */
public class PlayerEntity extends Entity {

    // Listener for player entity events
    private IPlayerEntityListener playerEntityListener;

    /**
     * Constructs a PlayerEntity object.
     * Initializes the step behavior for the player entity.
     * Sets the player entity listener to null by default.
     */
    public PlayerEntity() {
        // Initialize with an empty list of behaviors
        super(new ArrayList<IEntityBehavior>());
        // Set the step behavior for the player entity
        this.stepBehavior = new PlayerStepBehavior(this);
        // Set the player entity listener to null by default
        this.playerEntityListener = null;
    }

    /**
     * Indicates that the player entity has died.
     * Notifies the player entity listener about the player's death.
     */
    @Override
    public void die() {
        playerEntityListener.onPlayerDies();
    }

    /**
     * Indicates that the player entity has won.
     * Notifies the player entity listener about the player's victory.
     */
    public void win() {
        playerEntityListener.onPlayerWins();
    }

    /**
     * Sets the player entity listener.
     * @param playerEntityListener The listener to be set for player entity events.
     */
    public void setPlayerEntityListener(IPlayerEntityListener playerEntityListener) {
        this.playerEntityListener = playerEntityListener;
    }
}
