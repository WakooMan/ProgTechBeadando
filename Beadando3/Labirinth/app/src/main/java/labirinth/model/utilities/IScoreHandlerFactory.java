package labirinth.model.utilities;

/**
 * Interface for creating instances of IScoreHandler.
 */
public interface IScoreHandlerFactory {
    
    /**
     * Creates a new instance of IScoreHandler.
     *
     * @return A new instance of IScoreHandler.
     */
    IScoreHandler create();
}
