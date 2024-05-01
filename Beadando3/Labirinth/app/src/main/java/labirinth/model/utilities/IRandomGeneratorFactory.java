package labirinth.model.utilities;

/**
 * Interface for creating instances of IRandomGenerator.
 */
public interface IRandomGeneratorFactory {

    /**
     * Creates a new instance of IRandomGenerator.
     *
     * @return A new instance of IRandomGenerator.
     */
    public IRandomGenerator create();

}
