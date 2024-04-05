package labirinth.model.gamecontrol;

import java.util.ArrayList;
import java.util.List;
import labirinth.model.entities.IEntityStepper;
import labirinth.model.map.Map;
import labirinth.model.map.IMapGenerator;
import labirinth.model.map.IMapGeneratorFactory;
import labirinth.model.map.MapGeneratorFactory;

public class Game {

  private PlayerRepresentation playerRepresentation;

  private Map map;

  private final IMapGenerator mapGenerator;

  private boolean isGameOver;

  private final List<IEntityStepper> steppers;

  private boolean isRoundWon;

  public Game() {
      isGameOver = true;
      isRoundWon = true;
      this.steppers = new ArrayList<>();
      IMapGeneratorFactory factory = new MapGeneratorFactory();
      this.mapGenerator = factory.create();
  }

  public Map getMap() {
  return map;
  }

  public PlayerRepresentation getPlayerRepresentation() {
  return playerRepresentation;
  }

  public void startGame() {
      isGameOver = false;
      while(!isGameOver)
      {
          isRoundWon = false;
          this.map = this.mapGenerator.generateMap();
          while(!isRoundWon && !isGameOver)
          {
            onTick();
          }
          
          if(isRoundWon)
          {
              this.playerRepresentation.increaseMapCount();
          }
          
      }
  }

  private void onTick() {
      for(IEntityStepper stepper : steppers)
      {
          stepper.step();
      }
  }

}