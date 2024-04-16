package labirinth.model.utilities;
import java.awt.event.KeyListener;

public interface IKeyHandler extends KeyListener {

  public boolean isUpKeyDown();

  public boolean isDownKeyDown();

  public boolean isRightKeyDown();

  public boolean isLeftKeyDown();

}