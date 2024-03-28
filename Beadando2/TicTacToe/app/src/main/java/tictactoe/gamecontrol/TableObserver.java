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
    int column = 0;
    while(column < table.getColumnNum())
    {
        if(column > 2)
        {
            // Check diagonally to the right.
            if(checkDiagonally(column, false))
            {
                return 1;
            }
        }
        if(column < table.getColumnNum() - 3)
        {
            // Check diagonally to the left.
            if(checkDiagonally(column, true))
            {
                return 1;
            }
        }
        column++;
    }
    return 0;
  }

    @Override
    public boolean isTableFull() {
        for(int j = 0; j < table.getRowNum(); j++)
        {
            for(int i = 1; i < table.getColumnNum(); i++)
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
    
    private boolean checkDiagonally(int column, boolean toRight)
    {
        System.out.println(column + "," + toRight);
        int row = 0;
        AtomicInteger count = new AtomicInteger(1);
        Signal currentSignal = table.get(column, row).getSignal();
        for(row = 1; row < Math.min(column + 1, table.getRowNum()); row++)
        {
            int columnIndex = (toRight) ? column + row : column - row;
            System.out.println("Checking " + "(" + columnIndex + "," + row + ")");
            Field field = table.get(columnIndex, row);
            if(checkField(field, currentSignal, count))
            {
                return true;
            }
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