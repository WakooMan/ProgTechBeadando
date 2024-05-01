package labirinth.model.map;

import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IRandomGenerator;

/**
 * The MapGenerator class is responsible for generating the game map.
 */
public class MapGenerator implements IMapGenerator {

    private final IRandomGenerator random;

    /**
     * Constructs a MapGenerator object.
     */
    public MapGenerator() {
        random = ObjectCompositionUtils.getDefaultRandomGenerator();
    }

    /**
     * Generates a new game map.
     *
     * @return The generated game map.
     */
    @Override
    public Map generateMap() {
        int blockNum = MapConfiguration.getInstance().getBlockNum();
        Position blockSize = MapConfiguration.getInstance().getBlockSize();
        Block[][] blocks = new Block[blockNum][blockNum];
        MazeGenerator generator = new MazeGenerator(blockNum);
        Cell[][] cells = generator.generateMaze();

        // Create blocks based on the generated maze cells
        for (int i = 0; i < blockNum; i++) {
            for (int j = 0; j < blockNum; j++) {
                blocks[i][j] = new Block(new Position(j * blockSize.getX(), i * blockSize.getY()), cells[i][j]);
            }
        }

        // Select random positions for dragon spawn, player spawn, and win block
        CellPosition dragonSpawnPos = cells[random.generate(0, blockNum - 1)][random.generate(0, blockNum - 1)].getPosition();
        CellPosition winBlockPos = cells[0][blockNum - 1].getPosition();
        CellPosition playerSpawnPos = cells[blockNum - 1][0].getPosition();

        // Create and return the map with the generated blocks and positions
        return new Map(blocks, dragonSpawnPos, winBlockPos, playerSpawnPos);
    }
}
