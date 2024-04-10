package labirinth.model.utilities;

import java.awt.event.KeyListener;

public class KeyHandlerFactory implements IKeyHandlerFactory {

  private static final KeyHandler keyHandler = new KeyHandler();
    
  public KeyHandlerFactory() {
  }

  @Override
  public IKeyHandler createHandler() {
    return keyHandler;
  }

    @Override
    public KeyListener createListener() {
        return keyHandler;
    }

}