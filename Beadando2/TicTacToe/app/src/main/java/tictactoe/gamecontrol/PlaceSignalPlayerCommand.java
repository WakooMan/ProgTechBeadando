package tictactoe.gamecontrol;

import tictactoe.table.*;

public class PlaceSignalPlayerCommand implements IPlayerCommand {

  private final Integer columnIndex;

  private final Signal signal;

  public PlaceSignalPlayerCommand(Integer columnIndex, Signal signal) {
      this.columnIndex = columnIndex;
      this.signal = signal;
  }

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