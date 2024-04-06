package labirinth.model.map;

public class Road extends Block {

  public Road(Position upperLeftPoint) {
      super(upperLeftPoint);
  }

  @Override
  public boolean canStepOn() {
  return true;
  }

}