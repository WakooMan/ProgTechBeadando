/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.map;

import java.util.Arrays;
import java.util.Collections;
import labirinth.model.entities.Direction;

/**
 *
 * @author vitya
 */
public class MazeGenerator {
    
    private final Cell[][] cells;
    private final int blockNum;
      
    public MazeGenerator(int blockNum)
    {
        this.blockNum = blockNum;
        cells = new Cell[blockNum][blockNum];
        for(int i=0; i< blockNum; i++)
        {
            for(int j=0; j< blockNum; j++)
            {
                cells[i][j] = new Cell(new CellPosition(i, j));
            }
        }
    }
    
    public Cell[][] generateMaze()
    {
        generateMazeRecursive(cells[0][0].getPosition());
        return cells;
    }
    
    private void generateMazeRecursive(CellPosition cPos) {
		Direction[] dirs = Direction.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (Direction dir : dirs) {
                        
			CellPosition nPos = cPos.getCellPosition(dir);
                        if(nPos == null)
                        {
                            continue;
                        }
			if (between(nPos.getI(), blockNum) && between(nPos.getJ(), blockNum)
					&& inInitialState(cells[nPos.getI()][nPos.getJ()])) {
                                Cell cell = cells[cPos.getI()][cPos.getJ()];
				CellWall wall = cell.getWall(dir);
                                cell.removeWall(dir);
				cells[nPos.getI()][nPos.getJ()].removeWall(wall.getOpposite().getDirection());
				generateMazeRecursive(nPos);
			}
		}
	}
    
    private boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
    
    private boolean inInitialState(Cell cell)
        {
            return  cell.getWall(Direction.Up) != null &&
                    cell.getWall(Direction.Down) != null &&
                    cell.getWall(Direction.Right) != null &&
                    cell.getWall(Direction.Left) != null;
        }
    
}
