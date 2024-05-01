package labirinth.model.utilities;

import java.awt.event.KeyListener;

/**
 * Interface for handling keyboard input.
 * Extends KeyListener interface to provide methods for checking the status of directional keys.
 */
public interface IKeyHandler extends KeyListener {

    /**
     * Checks if the up arrow key is currently pressed.
     *
     * @return True if the up arrow key is pressed, false otherwise.
     */
    public boolean isUpKeyDown();

    /**
     * Checks if the down arrow key is currently pressed.
     *
     * @return True if the down arrow key is pressed, false otherwise.
     */
    public boolean isDownKeyDown();

    /**
     * Checks if the right arrow key is currently pressed.
     *
     * @return True if the right arrow key is pressed, false otherwise.
     */
    public boolean isRightKeyDown();

    /**
     * Checks if the left arrow key is currently pressed.
     *
     * @return True if the left arrow key is pressed, false otherwise.
     */
    public boolean isLeftKeyDown();

}
