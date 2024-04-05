package labirinth.model.map;

public class Position {

  private final double x;

  private final double y;

  public Position(double x, double y) {
      this.x = x;
      this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public Position addY(double addition) {
    return new Position(x, y + addition);
  }

  public Position addX(double addition) {
    return new Position(x + addition, y);
  }

}