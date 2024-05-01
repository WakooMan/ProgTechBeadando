package labirinth.model.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import labirinth.model.entities.Direction;

/**
 * The Map class represents the game map.
 */
public class Map {

    private final Block dragonSpawn;
    private final Block playerSpawn;
    private final Block winBlock;
    private final Block[][] blocks;

    /**
     * Constructs a Map object with the specified blocks, dragon spawn position, win block position, and player spawn position.
     *
     * @param blocks       The array of blocks composing the map.
     * @param dragonSpawn  The position of the dragon spawn.
     * @param winBlock     The position of the win block.
     * @param playerSpawn  The position of the player spawn.
     */
    public Map(Block[][] blocks, CellPosition dragonSpawn, CellPosition winBlock, CellPosition playerSpawn) {
        this.blocks = blocks;
        this.dragonSpawn = blocks[dragonSpawn.getI()][dragonSpawn.getJ()];
        this.playerSpawn = blocks[playerSpawn.getI()][playerSpawn.getJ()];
        this.winBlock = blocks[winBlock.getI()][winBlock.getJ()];
    }

    /**
     * Gets the block at the specified coordinates.
     *
     * @param i The row index of the block.
     * @param j The column index of the block.
     * @return The block at the specified coordinates, or null if the coordinates are out of bounds.
     */
    public Block getBlock(int i, int j) {
        if (i < 0 || i >= getBlockNum() || j < 0 || j >= getBlockNum()) {
            return null;
        }
        return blocks[i][j];
    }

    /**
     * Gets the player spawn block.
     *
     * @return The player spawn block.
     */
    public Block getPlayerSpawn() {
        return playerSpawn;
    }

    /**
     * Gets the dragon spawn block.
     *
     * @return The dragon spawn block.
     */
    public Block getDragonSpawn() {
        return dragonSpawn;
    }

    /**
     * Gets the win block.
     *
     * @return The win block.
     */
    public Block getWinBlock() {
        return winBlock;
    }

    /**
     * Gets the block at the specified position.
     *
     * @param position The position to get the block for.
     * @return The block at the specified position.
     */
    public Block getBlock(Position position) {
        int i = position.getY() / MapConfiguration.getInstance().getBlockSize().getY();
        int j = position.getX() / MapConfiguration.getInstance().getBlockSize().getX();
        return getBlock(i, j);
    }

    /**
     * Gets the blocks that intersect with the specified rectangle.
     *
     * @param position The rectangle to check for block intersections.
     * @return A set of blocks intersecting with the specified rectangle.
     */
    public HashSet<Block> getBlocks(Rectangle position) {
        HashSet<Block> result = new HashSet<>();
        result.add(getBlock(position.getUpperLeftPoint()));
        result.add(getBlock(position.getUpperRightPoint()));
        result.add(getBlock(position.getBottomLeftPoint()));
        result.add(getBlock(position.getBottomRightPoint()));
        return result;
    }

    /**
     * Gets the neighboring blocks of the specified block.
     *
     * @param block The block to get neighbors for.
     * @return A list of neighboring blocks.
     */
    public List<Block> getNeighbors(Block block) {
        List<Block> result = new ArrayList<>();
        CellPosition pos = block.getCell().getPosition();
        Direction[] directions = new Direction[]{Direction.Up, Direction.Down, Direction.Right, Direction.Left};
        for (Direction direction : directions) {
            CellPosition neighborPos = pos.getCellPosition(direction);
            Block bl = getBlock(neighborPos.getI(), neighborPos.getJ());
            if (bl != null && block.getCell().getWall(direction) == null) {
                result.add(bl);
            }
        }
        return result;
    }

    /**
     * Handles the map size change event.
     * This method updates the rectangles of all blocks based on the new map size configuration.
     */
    public void onMapSizeChanged() {
        for (int i = 0; i < getBlockNum(); i++) {
            for (int j = 0; j < getBlockNum(); j++) {
                Position blockSize = MapConfiguration.getInstance().getBlockSize();
                blocks[i][j].setRectangle(new Position(j * blockSize.getX(), i * blockSize.getY()));
            }
        }
    }

    /**
     * Gets the size of the map.
     *
     * @return The size of the map.
     */
    public Position getSize() {
        return MapConfiguration.getInstance().getMapSize();
    }

    /**
     * Gets the number of blocks in the map.
     *
     * @return The number of blocks in the map.
     */
    public int getBlockNum() {
        return MapConfiguration.getInstance().getBlockNum();
    }
}
