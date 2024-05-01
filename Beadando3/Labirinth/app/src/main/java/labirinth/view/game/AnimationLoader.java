package labirinth.view.game;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import labirinth.model.entities.Entity;
import labirinth.resources.ResourceLoader;

/**
 * Utility class for loading animations.
 */
public class AnimationLoader {
    
    /**
     * Loads an animation for the specified entity.
     *
     * @param entity The entity associated with the animation.
     * @param animation The base name of the animation resource files.
     * @param ms The duration of each frame in milliseconds.
     * @return The loaded Animation object.
     */
    public static Animation loadAnimation(Entity entity, String animation, int ms)
    {
        List<IAnimationFrame> frames = new ArrayList<>();
        boolean found = true;
        int i = 1;
        while(found)
        {
            try
            {
                String resource = animation + i + ".png";
                Image image = ResourceLoader.loadImage(resource);
                frames.add(new AnimationFrame(image, entity));
            }
            catch(IOException ex)
            {
                found = false;
            }
            i++;
        }
        return new Animation(frames, ms);
    }
}
