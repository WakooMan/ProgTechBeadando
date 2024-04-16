package labirinth.model.map;

import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IRandomGenerator;

public class MapGenerator implements IMapGenerator {
  
  private final IRandomGenerator random;
    
  public MapGenerator() {
      random = ObjectCompositionUtils.getDefaultRandomGenerator();
  }

  @Override
  public Map generateMap() {
    int blockNum = MapConfiguration.getInstance().getBlockNum();
    Position blockSize = MapConfiguration.getInstance().getBlockSize();
    Block[][] blocks = new Block[blockNum][blockNum];
    MazeGenerator generator = new MazeGenerator(blockNum);
    Cell[][] cells = generator.generateMaze();
    for(int i = 0; i < blockNum; i++)
    {
        for(int j = 0; j < blockNum; j++)
        {
            blocks[i][j] = new Block(new Position(j * blockSize.getX() , i * blockSize.getY()),cells[i][j]);
        }
    }
    
    return new Map(blocks, 
            cells[random.generate(0, blockNum - 1)][random.generate(0, blockNum - 1)].getPosition(), 
            cells[0][blockNum - 1].getPosition(), 
            cells[blockNum - 1][0].getPosition());
  }
}