package labirinth.model.map;

public class MapGenerator implements IMapGenerator {
  private final int blockNum;
  private final int blockSize;
    
  public MapGenerator() {
      blockNum = MapConfiguration.getInstance().getBlockNum();
      blockSize = MapConfiguration.getInstance().getBlockSize();
  }

  @Override
  public Map generateMap() {
    Block[][] blocks = new Block[blockNum][blockNum];
    MazeGenerator generator = new MazeGenerator(blockNum);
    Cell[][] cells = generator.generateMaze();
    for(int i = 0; i < blockNum; i++)
    {
        for(int j = 0; j < blockNum; j++)
        {
            blocks[i][j] = new Block(new Position(j * blockSize , i * blockSize),cells[i][j]);
        }
    }
    
    return new Map(blocks,cells[0][blockNum - 1].getPosition(), cells[blockNum - 1][0].getPosition());
  }
}