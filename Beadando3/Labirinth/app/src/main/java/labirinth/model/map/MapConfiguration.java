package labirinth.model.map;

public class MapConfiguration {

  private final int blockNum = 100;

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

  public int getStepSize() {
    return getBlockSize() / 5;
  }

  public int getMapSize() {
    return mapSize;
  }

  public void setMapSize(int mapSize) {
      this.mapSize = mapSize;
  }

}