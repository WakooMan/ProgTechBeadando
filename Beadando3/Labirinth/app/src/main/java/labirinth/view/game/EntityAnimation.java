package labirinth.view.game;

import java.awt.Graphics2D;
import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.Entity;

/**
 * Abstract class representing the animation for an entity.
 */
public abstract class EntityAnimation {
    private final HashMap<Direction, Animation> idleAnimations;
    private final HashMap<Direction, Animation> moveAnimations;
    private final Entity entity;
    private Animation currentAnimation;
    
    /**
     * Constructs an EntityAnimation object for the specified entity.
     *
     * @param entity The entity associated with this animation.
     * @param idleAnimations The animations for the entity when it is idle.
     * @param moveAnimations The animations for the entity when it is moving.
     */
    protected EntityAnimation(Entity entity, HashMap<Direction, Animation> idleAnimations, HashMap<Direction, Animation> moveAnimations)
    {
        this.entity = entity;
        this.idleAnimations = idleAnimations;
        this.moveAnimations = moveAnimations;
        currentAnimation = (entity.isMoving())? moveAnimations.get(entity.getDirection()) : idleAnimations.get(entity.getDirection());
    }
    
    /**
     * Updates the animation on each tick.
     *
     * @param dms The time elapsed since the last tick in milliseconds.
     * @param graphics The graphics context to render the animation.
     */
    public void onTick(int dms, Graphics2D graphics)
    {
        HashMap<Direction, Animation> animations;
        if(entity.isMoving())
        {
            animations = moveAnimations;
        }
        else
        {
            animations = idleAnimations;
        }
        if(currentAnimation != animations.get(entity.getDirection()))
        {
            currentAnimation.clear();
            currentAnimation = animations.get(entity.getDirection());
        }
        
        currentAnimation.onTick(dms, graphics);
    }
}
