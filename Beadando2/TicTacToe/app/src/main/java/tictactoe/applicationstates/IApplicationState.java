package tictactoe.applicationstates;

import tictactoe.views.View;

public interface IApplicationState {
    
  public View getView();
    
  public void onStateInitialize();
          
  public void onStateDestroy();

}