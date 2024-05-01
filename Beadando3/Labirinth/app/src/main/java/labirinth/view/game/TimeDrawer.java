/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import labirinth.model.map.MapConfiguration;

/**
 *
 * @author Viktor
 */
public class TimeDrawer implements IDrawable {

    private int hour;
    private int minute;
    private int seconds;
    private int ms;
    public TimeDrawer()
    {
        hour = 0;
        minute = 0;
        seconds = 0;
        ms = 0;
    }
    
    @Override
    public void draw(int dms, Graphics2D graphics) {
        ms += dms;
        if(ms > 1000)
        {
            seconds++;
            ms -= 1000;
            if(seconds >= 60)
            {
                minute++;
                seconds -= 60;
                if(minute >= 60)
                {
                    hour++;
                    minute -= 60;
                }
            }
        }
        int sizey = MapConfiguration.getInstance().getMapSize().getY() * 3 / 100;
        graphics.setColor(Color.green);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setFont(new Font("Arial", Font.PLAIN, sizey));
        graphics.drawString(hour + ":" + minute + ":" + seconds + ":" + ms, 0, sizey);
    }
    
}
