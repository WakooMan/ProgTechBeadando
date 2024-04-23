/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
        graphics.setColor(Color.green);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setStroke(new BasicStroke(10));
        graphics.drawString(hour + ":" + minute + ":" + seconds + ":" + ms, 10, 10);
    }
    
}
