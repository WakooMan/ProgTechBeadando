package labirinth.model.entities;

import labirinth.model.map.Position;

public interface IEntityListener {

  public void onPositionChanged(Position oldPosition, Position newPosition);

}