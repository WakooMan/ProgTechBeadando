package labirinth.model.utilities;

public class KeyHandlerFactory implements IKeyHandlerFactory {
    
  public KeyHandlerFactory() {
  }

  @Override
  public IKeyHandler create() {
    return new KeyHandler();
  }
}