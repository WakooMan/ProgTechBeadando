package labirinth.model.map;

import java.util.List;

public class Map {

  private final Block dragonSpawn;

  private final Block playerSpawn;
  private List<Block> blocks;

  public Map(List<Block> blocks, int dragonSpawnIndex, int playerSpawnIndex) {
      this.blocks = blocks;
      dragonSpawn = blocks.get(dragonSpawnIndex);
      playerSpawn = blocks.get(playerSpawnIndex);
  }

  public Block getBlock(int i, int j) {
    return null;
  }

  public Block getPlayerSpawn() {
    return playerSpawn;
  }

  public Block getDragonSpawn() {
    return dragonSpawn;
  }

  public Block getBlock(Position position) {
    return null;
  }

  public int getSize() {
    return MapConfiguration.getInstance().getMapSize();
  }

}