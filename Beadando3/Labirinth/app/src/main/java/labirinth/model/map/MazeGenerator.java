/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
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
        generateRoads(MapConfiguration.getInstance().getRoadNumber());
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
    
    private void generateRoads(int requiredCount)
    {
        AtomicInteger count;
        do{
            count = new AtomicInteger(0);
            CellPosition nearest = countRoadsBetween(count, new boolean[blockNum][blockNum], cells[blockNum - 1][0].getPosition(), cells[0][blockNum - 1].getPosition());
            removeRandomRoad(nearest);
        }while(count.get() < requiredCount);
        
    }
    
    private CellPosition countRoadsBetween(AtomicInteger count, boolean[][] visited, CellPosition pos, CellPosition destination)
    {
        CellPosition nearest = null;
        Direction[] dirs = Direction.values();
        Cell cell = cells[pos.getI()][pos.getJ()];
        visited[pos.getI()][pos.getJ()] = true;
        if(pos.getI() == destination.getI() && pos.getJ() == destination.getJ())
        {
            count.set(count.get() + 1);
            visited[pos.getI()][pos.getJ()] = false;
            return nearest;
        }
        int dirCount = 0;
        for (Direction dir : dirs) {
                        
			CellPosition nPos = pos.getCellPosition(dir);
                        if(nPos == null || cell.getWall(dir) != null || visited[nPos.getI()][nPos.getJ()])
                        {
                            continue;
                        }
			dirCount++;
                        CellPosition tmp = countRoadsBetween(count, visited,nPos, destination);
                        if(nearest == null || tmp.getLengthBetween(destination) < nearest.getLengthBetween(destination))
                        {
                            nearest = tmp;
                        }
		}
        if(dirCount == 0)
        {
            nearest = pos;
        }
        visited[pos.getI()][pos.getJ()] = false;
        return nearest;
    }
    
    private void removeRandomRoad(CellPosition position)
    {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {        
            CellPosition nPos = position.getCellPosition(dir);
            if(nPos == null)
            {
                continue;
            }
            if (between(nPos.getI(), blockNum) && between(nPos.getJ(), blockNum)) {
                    Cell cell = cells[position.getI()][position.getJ()];
                    CellWall wall = cell.getWall(dir);
                    if(wall != null)
                    {
                        cell.removeWall(dir);
                        cells[nPos.getI()][nPos.getJ()].removeWall(wall.getOpposite().getDirection());
                        break;
                    }
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
