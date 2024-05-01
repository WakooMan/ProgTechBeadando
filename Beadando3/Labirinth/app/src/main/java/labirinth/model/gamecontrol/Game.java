package labirinth.model.gamecontrol;

import java.util.ArrayList;
import java.util.List;
import labirinth.model.entities.Dragon;
import labirinth.model.entities.Entity;
import labirinth.model.entities.IEntityListener;
import labirinth.model.entities.IEntityStepper;
import labirinth.model.entities.IPositionValidator;
import labirinth.model.entities.PlayerEntity;
import labirinth.model.map.Block;
import labirinth.model.map.Map;
import labirinth.model.map.IMapGenerator;
import labirinth.model.map.IMapGeneratorFactory;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.MapGeneratorFactory;

/**
 * The Game class represents the main game control logic, including managing the player, map, entities, and game listeners.
 */
public class Game {

  private final PlayerRepresentation playerRepresentation;

  private Map map;

  private boolean wonMaze = false;
  private final IMapGenerator mapGenerator;
  private final IPositionValidator positionValidator;
  private final IEntityListener entityListener;
  private final DistanceListener distanceListener;

  private final List<IEntityStepper> steppers;
  
  private final List<IGameListener> gameListeners;
  
  private Dragon dragon;

  /**
   * Constructs a new Game instance with the specified player name.
   * 
   * @param playerName The name of the player.
   */
  public Game(String playerName) {
        this.dragon = null;
        this.playerRepresentation = new PlayerRepresentation(playerName);
        this.steppers = new ArrayList<>();
        this.gameListeners = new ArrayList<>();
        this.distanceListener = new DistanceListener(this);
        IMapGeneratorFactory factory = new MapGeneratorFactory();
        this.mapGenerator = factory.create();
        positionValidator = new PositionValidator(this);
        entityListener = new EntityListener(this);
        MapConfiguration.getInstance().addMapConfigurationListener(()-> 
        {
            if(map != null)
            {
                map.onMapSizeChanged();
            }
        });
  }

  /**
   * Gets the current map of the game.
   * 
   * @return The current map.
   */
  public Map getMap() {
  return map;
  }

  /**
   * Gets the player representation in the game.
   * 
   * @return The player representation.
   */
  public PlayerRepresentation getPlayerRepresentation() {
  return playerRepresentation;
  }

  /**
   * Adds a game listener to the game.
   * 
   * @param gameListener The game listener to add.
   */
  public void addGameListener(IGameListener gameListener)
  {
      gameListeners.add(gameListener);
  }
  
  /**
   * Starts the game by initializing the player entity and the map.
   */
  public void startGame()
  {
    PlayerEntity playerEntity = new PlayerEntity();
    playerEntity.setPlayerEntityListener(new PlayerEntityListener(() ->
    {
        for(IGameListener gameListener : gameListeners)
        {
            gameListener.onGameOver();
        }
    }, () -> 
    {
        this.playerRepresentation.increaseMapCount();
        wonMaze = true;
    }));
    this.playerRepresentation.setPlayerEntity(playerEntity);
    startMapGame();
  }
  
  private void startMapGame() {
        wonMaze = false;
        steppers.clear();
        this.map = this.mapGenerator.generateMap();
        this.spawnEntity(this.getPlayerRepresentation().getPlayerEntity(), this.map.getPlayerSpawn());
        this.dragon = new Dragon();
        this.spawnEntity(dragon, this.map.getDragonSpawn());
        for(IGameListener gameListener : gameListeners)
        {
            gameListener.onGameStarted();
        }
  }
  
  private void spawnEntity(Entity entity, Block block)
  {
    entity.initialize(block, positionValidator, entityListener);
    block.setEntity(entity);
    steppers.add(entity);
  }

  /**
   * Performs game logic on each tick of the game loop.
   */
  public void onTick() {
      if(wonMaze)
      {
        startMapGame();
      }
      for(IEntityStepper stepper : steppers)
      {
          stepper.step();
          distanceListener.listen();
      }
  }
  
  /**
   * Gets the dragon entity in the game.
   * 
   * @return The dragon entity.
   */
  public Dragon getDragon()
  {
      return dragon;
  }

}
