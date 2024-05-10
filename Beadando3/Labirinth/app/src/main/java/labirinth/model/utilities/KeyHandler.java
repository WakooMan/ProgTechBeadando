package labirinth.model.utilities;

import java.awt.event.KeyEvent;

/**
 * Handles keyboard input for arrow keys.
 * Implements the IKeyHandler interface.
 */
public class KeyHandler implements IKeyHandler {

    private boolean m_IsUpKeyDown = false;
    private boolean m_IsDownKeyDown = false;
    private boolean m_IsRightKeyDown = false;
    private boolean m_IsLeftKeyDown = false;
    
    /**
     * Constructs a KeyHandler.
     */
    public KeyHandler() {
    }

    @Override
    public boolean isUpKeyDown() {
        return m_IsUpKeyDown;
    }

    @Override
    public boolean isDownKeyDown() {
        return m_IsDownKeyDown;
    }

    @Override
    public boolean isRightKeyDown() {
        return m_IsRightKeyDown;
    }

    @Override
    public boolean isLeftKeyDown() {
        return m_IsLeftKeyDown;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this implementation
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Set the corresponding key flag to true when pressed
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP -> m_IsUpKeyDown = true;
            case KeyEvent.VK_W -> m_IsUpKeyDown = true;
            case KeyEvent.VK_DOWN -> m_IsDownKeyDown = true;
            case KeyEvent.VK_S -> m_IsDownKeyDown = true;
            case KeyEvent.VK_LEFT -> m_IsLeftKeyDown = true;
            case KeyEvent.VK_A -> m_IsLeftKeyDown = true;
            case KeyEvent.VK_RIGHT -> m_IsRightKeyDown = true;
            case KeyEvent.VK_D -> m_IsRightKeyDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Set the corresponding key flag to false when released
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP -> m_IsUpKeyDown = false;
            case KeyEvent.VK_W -> m_IsUpKeyDown = false;
            case KeyEvent.VK_DOWN -> m_IsDownKeyDown = false;
            case KeyEvent.VK_S -> m_IsDownKeyDown = false;
            case KeyEvent.VK_LEFT -> m_IsLeftKeyDown = false;
            case KeyEvent.VK_A -> m_IsLeftKeyDown = false;
            case KeyEvent.VK_RIGHT -> m_IsRightKeyDown = false;
            case KeyEvent.VK_D -> m_IsRightKeyDown = false;
        }
    }
}
