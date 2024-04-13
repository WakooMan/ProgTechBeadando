/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Graphics2D;

/**
 *
 * @author vitya
 */
public class EntityDrawer implements IDrawable {

    private final EntityAnimation animation;
    
    
    public EntityDrawer(EntityAnimation animation)
    {
        this.animation = animation;
    }
    
    @Override
    public void draw(int dms, Graphics2D graphics) {
        animation.onTick(dms, graphics);
    }
    
}
