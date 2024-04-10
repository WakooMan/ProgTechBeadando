package labirinth.model.entities;

import labirinth.model.map.Position;

public interface IPositionValidator {

  public boolean isValidPositionChange(Direction direction, Position oldPosition, Position newPosition);

}