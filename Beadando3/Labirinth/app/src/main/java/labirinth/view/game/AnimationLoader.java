/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import labirinth.model.entities.Entity;
import labirinth.resources.ResourceLoader;

/**
 *
 * @author vitya
 */
public class AnimationLoader {
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
