package labirinth.model.gamecontrol;

import labirinth.model.entities.PlayerEntity;

public class PlayerRepresentation {

  private final String name;
  private PlayerEntity playerEntity;

  private final int mapVision;

  public int mapCount;

  public PlayerRepresentation(String name) {
      this.name = name;
      this.mapVision = 3;
      this.mapCount = 0;
      this.playerEntity = null;
  }

  public PlayerEntity getPlayerEntity() {
  return playerEntity;
  }

  public void setPlayerEntity(PlayerEntity playerEntity) {
      this.playerEntity = playerEntity;
  }

  public int getMapVision() {
  return mapVision;
  }
  
  public String getName()
  {
      return name;
  }

  public void increaseMapCount() {
      this.mapCount++;
  }

  public int getMapCount() {
  return mapCount;
  }

}