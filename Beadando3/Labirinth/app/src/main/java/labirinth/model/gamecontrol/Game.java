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
import labirinth.model.map.MapGeneratorFactory;

public class Game {

  private PlayerRepresentation playerRepresentation;

  private Map map;

  private final IMapGenerator mapGenerator;
  private final IPositionValidator positionValidator;
  private final IEntityListener entityListener;

  private final List<IEntityStepper> steppers;
  
  private final List<IGameListener> gameListeners;

  public Game() {
        this.steppers = new ArrayList<>();
        this.gameListeners = new ArrayList<>();
        IMapGeneratorFactory factory = new MapGeneratorFactory();
        this.mapGenerator = factory.create();
        positionValidator = (position) -> 
        { 
            return this.map.getBlock(position).canStepOn();
        };
        entityListener = (entity ,oldPos, newPos)-> 
        {
            Block oldBlock = this.map.getBlock(oldPos);
            Block newBlock = this.map.getBlock(newPos);
            if(oldBlock != newBlock)
            {
                oldBlock.setEntity(null);
                newBlock.setEntity(entity);
            }

        };
  }

  public Map getMap() {
  return map;
  }

  public PlayerRepresentation getPlayerRepresentation() {
  return playerRepresentation;
  }

  public void addGameListener(IGameListener gameListener)
  {
      gameListeners.add(gameListener);
  }
  
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
        startMapGame();
    }));
    this.playerRepresentation.setPlayerEntity(playerEntity);
    startMapGame();
  }
  
  public void startMapGame() {
        steppers.clear();
        this.map = this.mapGenerator.generateMap();
        this.spawnEntity(this.getPlayerRepresentation().getPlayerEntity(), this.map.getPlayerSpawn());
        this.spawnEntity(new Dragon(), this.map.getDragonSpawn());
  }
  
  private void spawnEntity(Entity entity, Block block)
  {
    entity.initialize(block.getCenter(), positionValidator, entityListener);
    block.setEntity(entity);
    steppers.add(entity);
  }

  public void onTick() {
      for(IEntityStepper stepper : steppers)
      {
          stepper.step();
      }
  }

}