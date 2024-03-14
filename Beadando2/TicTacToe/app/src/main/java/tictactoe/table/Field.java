package tictactoe.table;

public class Field {

  private Signal signal;

  public Field(Signal signal) {
      this.signal = signal;
  }

  public Signal getSignal() {
  return signal;
  }

  public void setSignal(Signal signal) {
      this.signal = signal;
  }

}