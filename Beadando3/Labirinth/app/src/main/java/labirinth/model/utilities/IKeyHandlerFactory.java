package labirinth.model.utilities;

import java.awt.event.KeyListener;

public interface IKeyHandlerFactory {

  public IKeyHandler createHandler();
  
  public KeyListener createListener();

}