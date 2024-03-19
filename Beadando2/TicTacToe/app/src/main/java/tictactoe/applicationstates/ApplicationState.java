package tictactoe.applicationstates;

import tictactoe.views.View;

public abstract class ApplicationState implements IApplicationState {
    
  @Override
  public void onStateInitialize() {
      getView().initialize(this);
  }
    
  @Override
  public void onStateDestroy() {
      getView().clear();
  }
  
  @Override
  public abstract View getView();
  
}
