package labirinth.model.map;

import java.util.ArrayList;
import java.util.List;

public class MapConfiguration {

  private final int blockNum = 15;
  
  private int roadNumber = 3;

  private Position mapSize;
  
  private final List<IMapConfigurationListener> listeners;

  private static MapConfiguration instance;

  private MapConfiguration() {
      listeners = new ArrayList<>();
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
  
  public int getRoadNumber() {
    return roadNumber;
  }
  
  public void setRoadNumber(int roadNumber) {
    this.roadNumber = roadNumber;
  }
  
  public Position getBlockSize() {
    return new Position(mapSize.getX() / blockNum, mapSize.getY() / blockNum);
  }
  
  public Position getWallSize() {
    return new Position(getBlockSize().getX() / 5, getBlockSize().getY() / 5);
  }
  
  public Position getEntitySize() {
    return new Position(getBlockSize().getX() / 2, getBlockSize().getY() / 2);
  }

  public Position getStepSize() {
    return new Position(getBlockSize().getX() / 10, getBlockSize().getY() / 10);
  }
  
  public int getPlayerSight() {
    return Math.min(getBlockSize().getX(), getBlockSize().getY()) * 3;
  }

  public Position getMapSize() {
    return mapSize;
  }

  public void setMapSize(Position mapSize) {
      this.mapSize = mapSize;
      for(IMapConfigurationListener listener : listeners)
      {
          listener.onMapSizeChanged();
      }
  }
  
  public void addMapConfigurationListener(IMapConfigurationListener listener)
  {
      listeners.add(listener);
  }

}