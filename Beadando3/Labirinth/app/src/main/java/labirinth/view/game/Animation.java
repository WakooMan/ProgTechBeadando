package labirinth.view.game;

import java.awt.Graphics2D;
import java.util.List;

/**
 * Represents an animation composed of a sequence of frames.
 */
public class Animation {
    private final List<IAnimationFrame> frames;
    private final int ms;
    private int deltams;
    private IAnimationFrame currentFrame;
    
    /**
     * Constructs an Animation object.
     *
     * @param frames The list of frames that make up the animation.
     * @param ms The duration of each frame in milliseconds.
     */
    public Animation(List<IAnimationFrame> frames, int ms)
    {
        this.frames = frames;
        this.ms = ms;
        deltams = 0;
        currentFrame = frames.get(0);
    }
    
    /**
     * Executes the animation on each tick.
     *
     * @param dms The time elapsed since the last tick in milliseconds.
     * @param graphics The graphics context to render the animation.
     */
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
    
    /**
     * Resets the animation to its initial state.
     */
    public void clear()
    {
        deltams = 0;
        currentFrame = frames.get(0);
    }
}
