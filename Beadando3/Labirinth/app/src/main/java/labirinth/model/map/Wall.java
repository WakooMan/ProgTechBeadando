package labirinth.model.map;

public class Wall extends Block {

  public Wall(Position upperLeftPoint) {
      super(upperLeftPoint);
  }

  @Override
  public boolean canStepOn() {
    return false;
  }

}