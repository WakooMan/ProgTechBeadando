package tictactoe.gamecontrol;

import tictactoe.table.Field;
import tictactoe.table.Signal;
import tictactoe.table.Table;
import java.util.concurrent.atomic.AtomicInteger;

public class TableObserver implements ITableObserver {

  private final Table table;
  private MatchResult matchResult;

  public TableObserver(Table table) {
      this.table = table;
      this.matchResult = MatchResult.Ongoing;
  }
  
  @Override
  public int checkRows() {
    for(int row = 0; row < table.getRowNum(); row++)
    {
        AtomicInteger count = new AtomicInteger(1);
        int column = 0;
        Signal currentSignal = table.get(column, row).getSignal();
        for(column = 1; column < table.getColumnNum(); column++)
        {
            Field field = table.get(column, row);
            if(checkField(field, currentSignal, count))
            {
                return 1;
            }
        }
    }
    return 0;
  }

  @Override
  public int checkDiagonal() {
    if(checkDiagonally(true))
    {
        return 1;
    }
    
    if(checkDiagonally(false))
    {
        return 1;
    }
    
    return 0;
  }

    @Override
    public boolean isTableFull() {
        for(int j = 0; j < table.getRowNum(); j++)
        {
            for(int i = 0; i < table.getColumnNum(); i++)
            {
                Field field = table.get(i, j);
                if(field.getSignal() == Signal.Empty)
                {
                    return false;
                }
            }
        }
        matchResult = MatchResult.Draw;
        return true;
    }

    @Override
    public MatchResult getMatchResult() {
        return matchResult;
    }
    
    private boolean checkDiagonally(boolean isVertical)
    {
        int num = 0;
        int maxNum = (isVertical)? table.getColumnNum(): table.getRowNum();
        while(num < maxNum)
        {
            // Check diagonally to the right.
            if((isVertical && checkDiagonallyVertically(num, false)) || (!isVertical && checkDiagonallyHorizontally(num, false)))
            {
                return true;
            }
            
            // Check diagonally to the left.
            if((isVertical && checkDiagonallyVertically(num, true)) || (!isVertical && checkDiagonallyHorizontally(num, true)))
            {
                return true;
            }
            num++;
        }
        return false;
    }
    
    private boolean checkDiagonallyVertically(int column, boolean toRight)
    {
        int row = 0;
        int columnIndex = column;
        int addition = (toRight) ? 1 : -1;
        AtomicInteger count = new AtomicInteger(1);
        Signal currentSignal = table.get(columnIndex, row).getSignal();
        System.out.println("Checking vertically column:" + column);
        row++;
        columnIndex += addition;
        while(row < table.getRowNum() && columnIndex >= 0 && columnIndex < table.getColumnNum())
        {
            System.out.println("Checking vertically (" + columnIndex + "," + row + ")");
            
            if(checkField(table.get(columnIndex, row), currentSignal, count))
            {
                return true;
            }
            
            row++;
            columnIndex += addition;
        }
        
        return false;
    }
    
    private boolean checkDiagonallyHorizontally(int row, boolean toDown)
    {
        int column = 0;
        int rowIndex = row;
        int addition = (toDown) ? 1 : -1;
        AtomicInteger count = new AtomicInteger(1);
        Signal currentSignal = table.get(column, rowIndex).getSignal();
        System.out.println("Checking horizontally row:" + row);
        column++;
        rowIndex += addition;
        while(column < table.getColumnNum()&& rowIndex >= 0 && rowIndex < table.getRowNum())
        {
            System.out.println("Checking horizontally (" + column + "," + rowIndex + ")");
            
            if(checkField(table.get(column, rowIndex), currentSignal, count))
            {
                return true;
            }
            
            column++;
            rowIndex += addition;
        }
        
        return false;
    }
    
    
    private boolean checkField(Field field, Signal currentSignal, AtomicInteger count)
    {
        if(field.getSignal() != currentSignal)
        {
            count.set(1);
            currentSignal = field.getSignal();
        }
        else if(currentSignal != Signal.Empty)
        {
            count.set(count.get() + 1);
            if(count.get() >= 4)
            {
                if(currentSignal == Signal.O)
                {
                    matchResult = MatchResult.O;
                }
                else
                {
                    matchResult = MatchResult.X;
                }
                return true;
            }
        }
        return false;
    }

}