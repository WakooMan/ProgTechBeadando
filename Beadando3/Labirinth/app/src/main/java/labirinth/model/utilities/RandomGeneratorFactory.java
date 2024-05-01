package labirinth.model.utilities;

/**
 * Factory class for creating instances of RandomGenerator.
 * Implements the IRandomGeneratorFactory interface.
 */
public class RandomGeneratorFactory implements IRandomGeneratorFactory {

    /**
     * Constructs a RandomGeneratorFactory.
     */
    public RandomGeneratorFactory() {
    }

    @Override
    public IRandomGenerator create() {
        // Create and return a new instance of RandomGenerator
        return new RandomGenerator();
    }

}
