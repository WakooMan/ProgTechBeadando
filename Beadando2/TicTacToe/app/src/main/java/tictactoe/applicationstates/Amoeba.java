package tictactoe.applicationstates;

import tictactoe.gamecontrol.Match;

public class Amoeba implements IApplicationState {

  private final Match match;

  public Amoeba(Match match) {
      this.match = match;
  }

  @Override
  public void doAction() {
      while(!match.isGameOver())
      {
          match.stepWithCurrentPlayer();
      }
  }

}