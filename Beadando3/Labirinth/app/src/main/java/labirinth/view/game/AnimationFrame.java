package labirinth.view.game;

import java.awt.Graphics2D;
import java.awt.Image;
import labirinth.model.entities.Entity;
import labirinth.model.map.Rectangle;

/**
 * Represents a single frame of an animation.
 */
public class AnimationFrame implements IAnimationFrame {

    private final Image image;
    private final Entity entity;
    
    /**
     * Constructs an AnimationFrame object.
     *
     * @param image The image to be displayed in this frame.
     * @param entity The entity associated with this frame.
     */
    public AnimationFrame(Image image, Entity entity)
    {
        this.image = image;
        this.entity = entity;
    }
    
    @Override
    public void doFrame(Graphics2D graphics) {
        Rectangle rect = entity.getPosition();
        graphics.drawImage(image, rect.getUpperLeftPoint().getX(), rect.getUpperLeftPoint().getY(), rect.getWidth(), rect.getHeight(), (img, infoflags, nx, ny, w, h) -> false);
    }
    
}
