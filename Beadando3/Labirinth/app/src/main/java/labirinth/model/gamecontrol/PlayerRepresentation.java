package labirinth.model.gamecontrol;

import labirinth.model.entities.PlayerEntity;

public class PlayerRepresentation {

  private PlayerEntity playerEntity;

  private final int mapVision;

  public int mapCount;

  public PlayerRepresentation() {
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

  public void increaseMapCount() {
      this.mapCount++;
  }

  public int getMapCount() {
  return mapCount;
  }

}