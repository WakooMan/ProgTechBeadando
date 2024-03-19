package tictactoe.applicationstates;

import tictactoe.gamecontrol.Match;
import tictactoe.views.View;

public class TicTacToe extends ApplicationState {

  private final Match match;

  public TicTacToe(Match match) {
      this.match = match;
  }
  
   @Override
  public void onStateInitialize() {
      super.onStateInitialize();
      while(!match.isGameOver())
      {
          match.stepWithCurrentPlayer();
      }
  }

    @Override
    public View getView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}