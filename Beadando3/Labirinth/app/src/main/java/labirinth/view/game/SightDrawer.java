/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Color;
import java.awt.Graphics2D;
import labirinth.model.entities.PlayerEntity;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.model.map.Rectangle;

/**
 *
 * @author vitya
 */
public class SightDrawer implements IDrawable {

    private final PlayerEntity entity;
    private final MapConfiguration config;
    
    public SightDrawer(PlayerEntity entity)
    {
        this.entity = entity;
        config = MapConfiguration.getInstance();
    }
    
    @Override
    public void draw(int dms, Graphics2D graphics) {
        graphics.setColor(Color.black);
        Position upperLeftPos = new Position(Math.max(0,entity.getPosition().getCenter().getX() - config.getPlayerSight()), Math.max(0,entity.getPosition().getCenter().getY() - config.getPlayerSight()));
        Position bottomRightPos = new Position(Math.min(config.getMapSize().getX(),entity.getPosition().getCenter().getX() + config.getPlayerSight()), Math.min(config.getMapSize().getY(),entity.getPosition().getCenter().getY() + config.getPlayerSight()));
        Rectangle playerRect = new Rectangle(upperLeftPos, bottomRightPos.getX() - upperLeftPos.getX(), bottomRightPos.getY() - upperLeftPos.getY());
        graphics.fillRect(0, 0, playerRect.getUpperLeftPoint().getX(), config.getMapSize().getY());
        graphics.fillRect(0, 0, config.getMapSize().getX(), playerRect.getUpperLeftPoint().getY());
        graphics.fillRect(0, playerRect.getBottomLeftPoint().getY(), config.getMapSize().getX(), config.getMapSize().getY() - playerRect.getBottomLeftPoint().getY());
        graphics.fillRect(playerRect.getBottomRightPoint().getX(), 0, config.getMapSize().getX() - playerRect.getBottomRightPoint().getX(), config.getMapSize().getY());
        
        for(int dx = playerRect.getUpperLeftPoint().getX(); dx < playerRect.getBottomRightPoint().getX(); dx++)
        {
            for(int dy = playerRect.getUpperLeftPoint().getY(); dy < playerRect.getBottomRightPoint().getY(); dy++)
            {
                if(entity.getPosition().getCenter().createVector(new Position(dx, dy)).getLength() > config.getPlayerSight())
                {
                    graphics.drawLine(dx, dy, dx, dy);
                }
            }
        }
        
    }
    
}
