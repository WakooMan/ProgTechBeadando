/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Graphics2D;
import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.Entity;

/**
 *
 * @author vitya
 */
public abstract class EntityAnimation {
    private final HashMap<Direction, Animation> idleAnimations;
    private final HashMap<Direction, Animation> moveAnimations;
    private final Entity entity;
    private Animation currentAnimation;
    
    protected EntityAnimation(Entity entity, HashMap<Direction, Animation> idleAnimations, HashMap<Direction, Animation> moveAnimations)
    {
        //TODO: make abstract class and derived playerAnimation class
        this.entity = entity;
        this.idleAnimations = idleAnimations;
        this.moveAnimations = moveAnimations;
        currentAnimation = (entity.isMoving())? moveAnimations.get(entity.getDirection()) : idleAnimations.get(entity.getDirection());
    }
    
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
