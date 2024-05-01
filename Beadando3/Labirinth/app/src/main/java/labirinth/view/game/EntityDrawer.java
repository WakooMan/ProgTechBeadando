package labirinth.view.game;

import java.awt.Graphics2D;

/**
 * Represents a drawable entity that can be drawn on a graphics context.
 */
public class EntityDrawer implements IDrawable {

    private final EntityAnimation animation;
    
    
    /**
     * Constructs an EntityDrawer object with the specified animation.
     *
     * @param animation The animation associated with this entity drawer.
     */
    public EntityDrawer(EntityAnimation animation)
    {
        this.animation = animation;
    }
    
    @Override
    public void draw(int dms, Graphics2D graphics) {
        animation.onTick(dms, graphics);
    }
    
}
