/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author vitya
 */
public class Animation {
    private final List<IAnimationFrame> frames;
    private final int ms;
    private int deltams;
    private IAnimationFrame currentFrame;
    
    public Animation(List<IAnimationFrame> frames, int ms)
    {
        this.frames = frames;
        this.ms = ms;
        deltams = 0;
        currentFrame = frames.get(0);
    }
    
    public void onTick(int dms, Graphics2D graphics)
    {
        currentFrame.DoFrame(graphics);
        deltams += dms;
        if(deltams > ms)
        {
            currentFrame = (frames.indexOf(currentFrame) < frames.size() - 1) ? frames.get(frames.indexOf(currentFrame) + 1) : frames.get(0);
            deltams = 0;
        }
    }
    
    public void clear()
    {
        deltams = 0;
        currentFrame = frames.get(0);
    }
}
