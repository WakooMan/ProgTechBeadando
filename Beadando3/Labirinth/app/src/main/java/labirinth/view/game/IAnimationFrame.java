package labirinth.view.game;

import java.awt.Graphics2D;

/**
 * Interface representing a single frame of animation.
 */
public interface IAnimationFrame {
    
    /**
     * Executes the animation frame.
     *
     * @param graphics The graphics context to render the frame.
     */
    void DoFrame(Graphics2D graphics);
}
