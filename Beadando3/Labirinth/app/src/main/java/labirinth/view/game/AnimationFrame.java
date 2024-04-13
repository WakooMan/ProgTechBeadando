/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.function.Supplier;
import labirinth.model.entities.Entity;
import labirinth.model.map.Rectangle;

/**
 *
 * @author vitya
 */
public class AnimationFrame implements IAnimationFrame {

    private final Image image;
    private final Entity entity;
    
    public AnimationFrame(Image image, Entity entity)
    {
        this.image = image;
        this.entity = entity;
    }
    
    @Override
    public void DoFrame(Graphics2D graphics) {
        Rectangle rect = entity.getPosition();
        graphics.drawImage(image, rect.getUpperLeftPoint().getX(), rect.getUpperLeftPoint().getY(), rect.getWidth(), rect.getHeight(), (img, infoflags, nx, ny, w, h) -> false);
        
    }
    
}
