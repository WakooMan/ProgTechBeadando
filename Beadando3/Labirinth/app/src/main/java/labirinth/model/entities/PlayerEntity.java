package labirinth.model.entities;

import java.util.ArrayList;

public class PlayerEntity extends Entity {

  private IPlayerEntityListener playerEntityListener;

  public PlayerEntity() {
      super(new ArrayList<IEntityBehavior>());
      this.stepBehavior = new PlayerStepBehavior(this);
      this.playerEntityListener = null;
  }
  
  @Override
  public void die()
  {
      playerEntityListener.onPlayerDies();
  }
  
  public void win()
  {
      playerEntityListener.onPlayerWins();
  }

  public void setPlayerEntityListener(IPlayerEntityListener playerEntityListener) {
      this.playerEntityListener = playerEntityListener;
  }

    @Override
    public void onEntitySteppedNearby(Entity entity) {
        die();
    }

}