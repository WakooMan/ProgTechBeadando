package labirinth.model.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import labirinth.model.entities.Direction;

public class Map {

  private final Block dragonSpawn;

  private final Block playerSpawn;
  private final Block winBlock;
  private final Block[][] blocks;

  public Map(Block[][] blocks, CellPosition dragonSpawn, CellPosition winBlock, CellPosition playerSpawn) {
      this.blocks = blocks;
      this.dragonSpawn = blocks[dragonSpawn.getI()][dragonSpawn.getJ()];
      this.playerSpawn = blocks[playerSpawn.getI()][playerSpawn.getJ()];
      this.winBlock = blocks[winBlock.getI()][winBlock.getJ()];
  }

  public Block getBlock(int i, int j) {
    if(i < 0 || i >= getBlockNum() || j < 0 || j >= getBlockNum())
    {
        return null;
    }
    return blocks[i][j];
  }

  public Block getPlayerSpawn() {
    return playerSpawn;
  }

  public Block getDragonSpawn() {
    return dragonSpawn;
  }
  
  public Block getWinBlock() {
    return winBlock;
  }

  public Block getBlock(Position position) {
    int i = position.getY() / MapConfiguration.getInstance().getBlockSize().getY();
    int j = position.getX() / MapConfiguration.getInstance().getBlockSize().getX();
    if(i < 0 || i >= getBlockNum() || j < 0 || j >= getBlockNum())
    {
        return null;
    }
    return blocks[i][j];
  }
  
  public HashSet<Block> getBlocks(Rectangle position) {
    HashSet<Block> result = new HashSet<>();
    result.add(getBlock(position.getUpperLeftPoint()));
    result.add(getBlock(position.getUpperRightPoint()));
    result.add(getBlock(position.getBottomLeftPoint()));
    result.add(getBlock(position.getBottomRightPoint()));
    return result;
  }
  
  public List<Block> getNeighbors(Block block)
  {
      List<Block> result = new ArrayList<>();
      CellPosition pos = block.getCell().getPosition();
      Direction[] directions = new Direction[]
      {
          Direction.Up,
          Direction.Down,
          Direction.Right,
          Direction.Left
      };
      for(Direction direction : directions)
      {
          CellPosition neighborPos = pos.getCellPosition(direction);
          Block bl = getBlock(neighborPos.getI(), neighborPos.getJ());
          if(bl != null && block.getCell().getWall(direction) == null)
          {
              result.add(bl);
          }
      }
      return result;
  }
  
  public void onMapSizeChanged()
  {
      for(int i = 0; i < getBlockNum(); i++)
      {
        for(int j = 0; j < getBlockNum(); j++)
        {
            Position blockSize = MapConfiguration.getInstance().getBlockSize();
            blocks[i][j].setRectangle(new Position(j * blockSize.getX() , i * blockSize.getY()));
        }
      }
  }

  public Position getSize() {
    return MapConfiguration.getInstance().getMapSize();
  }
  
  public int getBlockNum() {
    return MapConfiguration.getInstance().getBlockNum();
  }

}