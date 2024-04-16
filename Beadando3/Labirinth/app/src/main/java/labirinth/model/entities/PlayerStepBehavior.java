package labirinth.model.entities;

import labirinth.model.ObjectCompositionUtils;
import labirinth.model.utilities.IKeyHandler;

/*
 */
public class PlayerStepBehavior extends StepBehavior {

  private final IKeyHandler keyHandler;

  public PlayerStepBehavior(PlayerEntity player) {
      super(player);
      keyHandler = ObjectCompositionUtils.getDefaultKeyHandler();
  }

  @Override
  protected Direction getDirection() {
    if(keyHandler.isUpKeyDown())
     return Direction.Up;
    if(keyHandler.isDownKeyDown())
     return Direction.Down;
    if(keyHandler.isRightKeyDown())
     return Direction.Right;
    if(keyHandler.isLeftKeyDown())
     return Direction.Left;
    return null;

  }

}