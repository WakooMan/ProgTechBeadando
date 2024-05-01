package labirinth.model.entities;

import java.util.ArrayList;

/**
 * Represents a Dragon entity in the labyrinth.
 * Dragons are a type of entity that can move within the labyrinth.
 */
public class Dragon extends Entity {

    /**
     * Constructs a Dragon object.
     * Initializes the step behavior for the dragon.
     */
    public Dragon() {
        // Initialize with an empty list of behaviors
        super(new ArrayList<IEntityBehavior>());
        // Set the step behavior for the dragon
        this.stepBehavior = new DragonStepBehavior(this);
    }
}
