package labirinth.model.gamecontrol;

import labirinth.model.entities.PlayerEntity;

/**
 * The PlayerRepresentation class represents a player in the game, storing information
 * such as the player's name, associated player entity, map vision, and map count.
 */
public class PlayerRepresentation {

  private final String name; // The name of the player
  private PlayerEntity playerEntity; // The player entity associated with the player
  private final int mapVision; // The map vision range of the player
  private int mapCount; // The number of maps the player has completed

  /**
   * Constructs a PlayerRepresentation object with the specified player name.
   * 
   * @param name The name of the player.
   */
  public PlayerRepresentation(String name) {
      this.name = name;
      this.mapVision = 3; // Default map vision range
      this.mapCount = 0; // Initialize map count to 0
      this.playerEntity = null; // Player entity is initially null
  }

  /**
   * Returns the player entity associated with this player.
   * 
   * @return The player entity associated with this player.
   */
  public PlayerEntity getPlayerEntity() {
      return playerEntity;
  }

  /**
   * Sets the player entity associated with this player.
   * 
   * @param playerEntity The player entity to be associated with this player.
   */
  public void setPlayerEntity(PlayerEntity playerEntity) {
      this.playerEntity = playerEntity;
  }

  /**
   * Returns the map vision range of the player.
   * 
   * @return The map vision range of the player.
   */
  public int getMapVision() {
      return mapVision;
  }
  
  /**
   * Returns the name of the player.
   * 
   * @return The name of the player.
   */
  public String getName() {
      return name;
  }

  /**
   * Increases the map count when the player completes a map.
   */
  public void increaseMapCount() {
      this.mapCount++;
  }

  /**
   * Returns the number of maps the player has completed.
   * 
   * @return The number of maps the player has completed.
   */
  public int getMapCount() {
      return mapCount;
  }

}
