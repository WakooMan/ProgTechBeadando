package labirinth.model.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import labirinth.model.entities.Direction;

/**
 * MazeGenerator class generates a maze using recursive backtracking algorithm.
 */
public class MazeGenerator {
    
    private final Cell[][] cells; // 2D array to hold the maze cells
    private final int blockNum; // Size of the maze grid
      
    /**
     * Constructor to initialize the MazeGenerator.
     * @param blockNum The size of the maze grid.
     */
    public MazeGenerator(int blockNum)
    {
        this.blockNum = blockNum;
        cells = new Cell[blockNum][blockNum]; // Initialize the maze grid
        // Initialize each cell in the grid
        for(int i=0; i< blockNum; i++)
        {
            for(int j=0; j< blockNum; j++)
            {
                cells[i][j] = new Cell(new CellPosition(i, j));
            }
        }
    }
    
    /**
     * Generates a maze using the recursive backtracking algorithm.
     * @return A 2D array representing the generated maze.
     */
    public Cell[][] generateMaze()
    {
        // Start generating the maze recursively from the top-left cell
        generateMazeRecursive(cells[0][0].getPosition());
        // Generate roads (paths) through the maze
        generateRoads(MapConfiguration.getInstance().getRoadNumber());
        return cells; // Return the generated maze
    }
    
    // Recursive method to generate the maze
    private void generateMazeRecursive(CellPosition cPos) {
		Direction[] dirs = Direction.values();
		Collections.shuffle(Arrays.asList(dirs)); // Shuffle the directions to randomize maze generation
		for (Direction dir : dirs) {
            // Get the position of the neighboring cell in the current direction
			CellPosition nPos = cPos.getCellPosition(dir);
            // Check if the neighboring cell position is valid and not visited
            if(nPos == null)
            {
                continue;
            }
			if (between(nPos.getI(), blockNum) && between(nPos.getJ(), blockNum)
					&& inInitialState(cells[nPos.getI()][nPos.getJ()])) {
                // If the neighboring cell is valid and in initial state, remove the wall between the current cell and the neighboring cell
                Cell cell = cells[cPos.getI()][cPos.getJ()];
				CellWall wall = cell.getWall(dir);
                cell.removeWall(dir);
				cells[nPos.getI()][nPos.getJ()].removeWall(wall.getOpposite().getDirection());
				generateMazeRecursive(nPos); // Recursively generate the maze starting from the neighboring cell
			}
		}
	}
    
    // Method to generate roads through the maze
    private void generateRoads(int requiredCount)
    {
        AtomicInteger count;
        do{
            count = new AtomicInteger(0);
            List<CellPosition> positions = new ArrayList<>();
            countRoadsBetween(count, new boolean[blockNum][blockNum], cells[blockNum - 1][0].getPosition(), cells[0][blockNum - 1].getPosition(), positions);
            if(positions.isEmpty())
            {
                System.out.println("Empty");
                break;
            }
            Collections.shuffle(positions);
            CellPosition chosen = positions.get(0);
            removeRandomRoad(chosen);
        }while(count.get() < requiredCount);
        
    }
    
    // Method to count roads between two points in the maze
    private void countRoadsBetween(AtomicInteger count, boolean[][] visited, CellPosition pos, CellPosition destination, List<CellPosition> positions)
    {
        Direction[] dirs = Direction.values();
        Cell cell = cells[pos.getI()][pos.getJ()];
        visited[pos.getI()][pos.getJ()] = true;
        // If the current position is the destination, increment the road count and return
        if(pos.getI() == destination.getI() && pos.getJ() == destination.getJ())
        {
            count.set(count.get() + 1);
            visited[pos.getI()][pos.getJ()] = false;
            return;
        }
        int dirCount = 0;
        for (Direction dir : dirs) {
            // Get the position of the neighboring cell in each direction
            CellPosition nPos = pos.getCellPosition(dir);
            // Check if the neighboring cell position is valid and not visited
            if(nPos == null || cell.getWall(dir) != null || visited[nPos.getI()][nPos.getJ()])
            {
                continue;
            }
			dirCount++;
            // Recursively count roads starting from the neighboring cell
            countRoadsBetween(count, visited, nPos, destination, positions);
	}
        // If there are no valid neighboring cells, add the current position to the list of positions
        if(dirCount == 0)
        {
            positions.add(pos);
        }
        visited[pos.getI()][pos.getJ()] = false;
    }
    
    // Method to remove a random road (wall) in the maze
    private void removeRandomRoad(CellPosition position)
    {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs)); // Shuffle the directions to randomly select a direction
        for (Direction dir : dirs) {        
            CellPosition nPos = position.getCellPosition(dir);
            if(nPos == null)
            {
                continue;
            }
            if (between(nPos.getI(), blockNum) && between(nPos.getJ(), blockNum)) {
                Cell cell = cells[position.getI()][position.getJ()];
                CellWall wall = cell.getWall(dir);
                // If the wall in the selected direction exists, remove it
                if(wall != null)
                {
                    cell.removeWall(dir);
                    cells[nPos.getI()][nPos.getJ()].removeWall(wall.getOpposite().getDirection());
                    break;
                }
            }
		}
    }
    
    // Method to check if a value is within a specified range
    private boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
    
    // Method to check if a cell is in the initial state (with all walls intact)
    private boolean inInitialState(Cell cell)
    {
        return  cell.getWall(Direction.Up) != null &&
                cell.getWall(Direction.Down) != null &&
                cell.getWall(Direction.Right) != null &&
                cell.getWall(Direction.Left) != null;
    }
    
}
