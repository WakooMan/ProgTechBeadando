package labirinth.model.utilities;

/**
 * Factory class for creating instances of ScoreHandler.
 * Implements the IScoreHandlerFactory interface.
 */
public class ScoreHandlerFactory implements IScoreHandlerFactory {

    @Override
    public IScoreHandler create() {
        // Create and return a new instance of ScoreHandler
        return new ScoreHandler();
    }
}
