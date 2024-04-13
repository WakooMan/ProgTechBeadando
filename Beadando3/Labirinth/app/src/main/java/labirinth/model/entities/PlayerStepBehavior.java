package labirinth.model.entities;

import labirinth.model.utilities.IKeyHandler;
import labirinth.model.utilities.IKeyHandlerFactory;
import labirinth.model.utilities.KeyHandlerFactory;

/*
 */
public class PlayerStepBehavior extends StepBehavior {

  private final IKeyHandler keyHandler;

  public PlayerStepBehavior(PlayerEntity player) {
      super(player);
      IKeyHandlerFactory factory = new KeyHandlerFactory();
      keyHandler = factory.createHandler();
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