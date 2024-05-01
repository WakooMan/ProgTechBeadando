package labirinth.model.utilities;

/**
 * Factory class for creating instances of KeyHandler.
 * Implements the IKeyHandlerFactory interface.
 */
public class KeyHandlerFactory implements IKeyHandlerFactory {
    
    /**
     * Constructs a KeyHandlerFactory.
     */
    public KeyHandlerFactory() {
    }

    @Override
    public IKeyHandler create() {
        // Create and return a new instance of KeyHandler
        return new KeyHandler();
    }
}
