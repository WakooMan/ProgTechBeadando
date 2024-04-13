package labirinth.model.entities;

import labirinth.model.map.Rectangle;

public interface IEntityListener {

  public void onPositionChanged(Entity entity, Rectangle oldPosition, Rectangle newPosition);

}