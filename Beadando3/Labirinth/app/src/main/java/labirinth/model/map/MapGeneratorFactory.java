package labirinth.model.map;

/**
 * The MapGeneratorFactory class creates instances of MapGenerator.
 */
public class MapGeneratorFactory implements IMapGeneratorFactory {

    /**
     * Constructs a MapGeneratorFactory object.
     */
    public MapGeneratorFactory() {
    }

    /**
     * Creates a new instance of MapGenerator.
     *
     * @return A new instance of MapGenerator.
     */
    @Override
    public IMapGenerator create() {
        return new MapGenerator();
    }
}
