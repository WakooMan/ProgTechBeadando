package tictactoe.gamecontrol;

import tictactoe.table.*;

/**
 * Player command for throwing signal at the specified column.
 */
public class PlaceSignalPlayerCommand implements IPlayerCommand {

  private final Integer columnIndex;

  private final Signal signal;

  /**
   * Constructor.
   * @param columnIndex column index, where the signal is placed.
   * @param signal signal.
   */
  public PlaceSignalPlayerCommand(Integer columnIndex, Signal signal) {
      this.columnIndex = columnIndex;
      this.signal = signal;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(Table table) {
      Column column = table.get(columnIndex);
      int i = 0;
      Field previousField = null;
      Field field = column.get(i);
      while( i < column.size() && Signal.Empty.equals(field.getSignal()))
      {
        if(previousField != null)
        {
            previousField.setSignal(Signal.Empty);
        }
        field.setSignal(signal);
        //Invoke event for view change.
        i++;
        previousField = field;
        field = (i < column.size())? column.get(i) : null;
      }
      
  }

}