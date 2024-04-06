package labirinth.model.entities;

import labirinth.model.map.Position;

public interface IEntityListener {

  public void onPositionChanged(Entity entity, Position oldPosition, Position newPosition);

}