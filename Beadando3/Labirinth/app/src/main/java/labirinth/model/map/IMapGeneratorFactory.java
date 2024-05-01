package labirinth.model.map;

/**
 * The IMapGeneratorFactory interface defines a method for creating map generator instances.
 */
public interface IMapGeneratorFactory {

    /**
     * Creates a new instance of IMapGenerator.
     *
     * @return A new instance of IMapGenerator.
     */
    IMapGenerator create();
}
