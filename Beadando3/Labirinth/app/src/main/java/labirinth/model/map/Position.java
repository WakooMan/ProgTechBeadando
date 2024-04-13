package labirinth.model.map;

public class Position {

  private final int x;

  private final int y;

  public Position(int x, int y) {
      this.x = x;
      this.y = y;
  }
  
  public Position(Position position) {
      this.x = position.x;
      this.y = position.y;
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
  
  public Position createVector(Position p2)
  {
      return new Position(x - p2.x, y - p2.y);
  }
  
  public int getLength()
  {
      return (int)Math.sqrt((x * x) + (y * y));
  }

}