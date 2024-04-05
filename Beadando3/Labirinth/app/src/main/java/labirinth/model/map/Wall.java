package labirinth.model.map;

public class Wall extends Block {

  public Wall() {
  }

  @Override
  public boolean canStepOn() {
    return false;
  }

}