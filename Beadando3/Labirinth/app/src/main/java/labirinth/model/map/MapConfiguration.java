package labirinth.model.map;

public class MapConfiguration {

  private final int blockNum = 15;

  private int mapSize;

  private static MapConfiguration instance;

  private MapConfiguration() {
  }

  public static MapConfiguration getInstance() {
    if(instance == null)
    {
        instance = new MapConfiguration();
    }
    return instance;
  }

  public int getBlockNum() {
    return blockNum;
  }

  public int getBlockSize() {
    return mapSize / blockNum;
  }
  
  public int getWallSize() {
    return getBlockSize()/ 5;
  }
  
  public int getEntitySize() {
    return getBlockSize()/ 5;
  }

  public int getStepSize() {
    return getBlockSize() / 10;
  }

  public int getMapSize() {
    return mapSize;
  }

  public void setMapSize(int mapSize) {
      this.mapSize = mapSize;
  }

}