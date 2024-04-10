package labirinth.model.map;

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
    return blocks[i][j];
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
  
  public int getBlockNum() {
    return MapConfiguration.getInstance().getBlockNum();
  }

}