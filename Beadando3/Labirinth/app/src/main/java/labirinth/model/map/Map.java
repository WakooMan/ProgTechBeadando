package labirinth.model.map;

import java.util.ArrayList;
import java.util.List;
import labirinth.model.entities.Direction;

public class Map {

  private final Block dragonSpawn;

  private final Block playerSpawn;
  private final Block[][] blocks;

  public Map(Block[][] blocks, CellPosition dragonSpawn, CellPosition playerSpawn) {
      this.blocks = blocks;
      this.dragonSpawn = blocks[dragonSpawn.getI()][dragonSpawn.getJ()];
      this.playerSpawn = blocks[playerSpawn.getI()][playerSpawn.getJ()];
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

  public Block getBlock(Position position) {
    int i = position.getY() / MapConfiguration.getInstance().getBlockSize();
    int j = position.getX() / MapConfiguration.getInstance().getBlockSize();
    if(i < 0 || i >= getBlockNum() || j < 0 || j >= getBlockNum())
    {
        return null;
    }
    return blocks[i][j];
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

  public int getSize() {
    return MapConfiguration.getInstance().getMapSize();
  }
  
  public int getBlockNum() {
    return MapConfiguration.getInstance().getBlockNum();
  }

}