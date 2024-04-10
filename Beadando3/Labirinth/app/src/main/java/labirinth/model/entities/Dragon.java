package labirinth.model.entities;

import java.util.ArrayList;

public class Dragon extends Entity {

  public Dragon() {
      super(new ArrayList<IEntityBehavior>());
      this.stepBehavior = new DragonStepBehavior(this);
  }

    @Override
    public void onEntitySteppedNearby(Entity entity) {
        die();
    }

}