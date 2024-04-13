package labirinth.model.entities;

import labirinth.model.map.Rectangle;

public interface IPositionValidator {

  public boolean isValidPositionChange(Direction direction, Rectangle oldPosition, Rectangle newPosition);

}