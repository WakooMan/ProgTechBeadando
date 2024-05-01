package labirinth.model;

import labirinth.model.utilities.*;

/**
 * Utility class for managing object composition in the labyrinth model.
 * Provides default implementations for key handling, random number generation,
 * and score handling.
 * This class follows the Singleton pattern for providing default instances of
 * composition objects.
 * 
 * @author vitya
 */
public class ObjectCompositionUtils {
    private static IKeyHandler keyHandler;
    private static IRandomGenerator randomGenerator;
    private static IScoreHandler scoreHandler;
    
    /**
     * Returns the default key handler instance.
     * If not already instantiated, creates a new instance using the
     * KeyHandlerFactory.
     * 
     * @return Default key handler instance
     */
    public static IKeyHandler getDefaultKeyHandler() {
        if(keyHandler == null) {
            IKeyHandlerFactory factory = new KeyHandlerFactory();
            keyHandler = factory.create();
        }
        return keyHandler;
    }
    
    /**
     * Returns the default random number generator instance.
     * If not already instantiated, creates a new instance using the
     * RandomGeneratorFactory.
     * 
     * @return Default random number generator instance
     */
    public static IRandomGenerator getDefaultRandomGenerator() {
        if(randomGenerator == null) {
            IRandomGeneratorFactory factory = new RandomGeneratorFactory();
            randomGenerator = factory.create();
        }
        return randomGenerator;
    }
    
    /**
     * Returns the default score handler instance.
     * If not already instantiated, creates a new instance using the
     * ScoreHandlerFactory.
     * 
     * @return Default score handler instance
     */
    public static IScoreHandler getDefaultScoreHandler() {
        if(scoreHandler == null) {
            IScoreHandlerFactory factory = new ScoreHandlerFactory();
            scoreHandler = factory.create();
        }
        return scoreHandler;
    }
}