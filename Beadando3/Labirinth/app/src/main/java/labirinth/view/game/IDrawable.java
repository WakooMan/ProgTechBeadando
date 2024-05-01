package labirinth.view.game;

import java.awt.Graphics2D;

/**
 * Interface representing an object that can be drawn.
 */
public interface IDrawable {
    
    /**
     * Draws the object.
     *
     * @param dms The time elapsed since the last draw in milliseconds.
     * @param graphics The graphics context to render the object.
     */
    void draw(int dms, Graphics2D graphics);
}
