/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.map;

import labirinth.model.entities.Direction;

/**
 *
 * @author vitya
 */
public class CellPosition {
  private final int i;
  private final int j;

  public CellPosition(int i, int j) {
      this.i = i;
      this.j = j;
  }

  public int getI() {
    return i;
  }

  public int getJ() {
    return j;
  }

  public CellPosition addJ(int addition) {
    return new CellPosition(i, j + addition);
  }

  public CellPosition addI(int addition) {
    return new CellPosition(i + addition, j);
  }
  
  public CellPosition getCellPosition(Direction direction)
  {
      switch(direction)
      {
          case Up -> {
              return addI(-1);
            }
          case Down -> {
              return addI(1);
            }
          case Right -> {
              return addJ(1);
            }
          case Left -> {
              return addJ(-1);
            }



      }
      return null;
  }

}
