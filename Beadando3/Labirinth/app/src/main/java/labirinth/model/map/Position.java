package labirinth.model.map;

public class Position {

  private final int x;

  private final int y;

  public Position(int x, int y) {
      this.x = x;
      this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Position addY(int addition) {
    return new Position(x, y + addition);
  }

  public Position addX(int addition) {
    return new Position(x + addition, y);
  }

}