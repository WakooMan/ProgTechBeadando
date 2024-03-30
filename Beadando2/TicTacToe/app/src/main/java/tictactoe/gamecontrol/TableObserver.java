package tictactoe.gamecontrol;

import tictactoe.table.Field;
import tictactoe.table.Signal;
import tictactoe.table.Table;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implements ITableObserver interface and it is responsible for checking the table.
 */
public class TableObserver implements ITableObserver {

  private final Table table;
  private MatchResult matchResult;

  /**
   * Constructor for creating TableObserver object.
   * @param table table of the match.
   */
  public TableObserver(Table table) {
      this.table = table;
      this.matchResult = MatchResult.Ongoing;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public int checkRows() {
    for(int row = 0; row < table.getRowNum(); row++)
    {
        AtomicInteger count = new AtomicInteger(1);
        int column = 0;
        SignalContainer currentSignalContainer = new SignalContainer(table.get(column, row).getSignal());
        for(column = 1; column < table.getColumnNum(); column++)
        {
            Field field = table.get(column, row);
            if(checkField(field, currentSignalContainer, count))
            {
                return 1;
            }
        }
    }
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int checkDiagonal() {
    if(checkDiagonallyToDown())
    {
        return 1;
    }
    
    if(checkDiagonallyToUp())
    {
        return 1;
    }
    
    return 0;
  }

   /**
   * {@inheritDoc}
   */
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
    
    /**
    * {@inheritDoc}
    */
    @Override
    public boolean isColumnFull(int column) {
        for(int j = 0; j < table.getRowNum(); j++)
        {
            Field field = table.get(column, j);
            if(field.getSignal() == Signal.Empty)
            {
                return false;
            }
        }
        return true;
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public MatchResult getMatchResult() {
        return matchResult;
    }
    
    private boolean checkDiagonallyToDown()
    {
        for(int column = table.getColumnNum() - 1; column >= 0; column--)
        {
            if(checkDiagonally(column, 0, true))
            {
                return true;
            }
        }
        
        for(int row = 0; table.getRowNum() > row; row++)
        {
            if(checkDiagonally(0, row, true))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkDiagonallyToUp()
    {   
        for(int row = 0; table.getRowNum() > row; row++)
        {
            if(checkDiagonally(0, row, false))
            {
                return true;
            }
        }
        
        for(int column = 0; table.getColumnNum() > column; column++)
        {
            if(checkDiagonally(column, table.getRowNum() - 1, false))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean checkDiagonally(int column, int row, boolean toDown)
    {
        int addition = (toDown) ? 1 : -1;
        AtomicInteger count = new AtomicInteger(1);
        SignalContainer currentSignalContainer = new SignalContainer(table.get(column, row).getSignal());
        column++;
        row += addition;
        while(column < table.getColumnNum() && row >= 0 && row < table.getRowNum())
        {
            if(checkField(table.get(column, row), currentSignalContainer, count))
            {
                return true;
            }
            
            column++;
            row += addition;
        }
        
        return false;
    }
    
    private boolean checkField(Field field, SignalContainer signalContainer, AtomicInteger count)
    {
        if(field.getSignal() != signalContainer.getSignal())
        {
            count.set(1);
            signalContainer.setSignal(field.getSignal());
        }
        else if(signalContainer.getSignal() != Signal.Empty)
        {
            count.set(count.get() + 1);
            System.out.println("Count: " + count.get());
            if(count.get() >= 4)
            {
                if(signalContainer.getSignal() == Signal.O)
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