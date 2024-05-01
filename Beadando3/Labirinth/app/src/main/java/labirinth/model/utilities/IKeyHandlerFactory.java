package labirinth.model.utilities;

/**
 * Interface for creating instances of IKeyHandler.
 */
public interface IKeyHandlerFactory {

    /**
     * Creates a new instance of IKeyHandler.
     *
     * @return A new instance of IKeyHandler.
     */
    public IKeyHandler create();

}
