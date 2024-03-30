package tictactoe.applicationstates;

import tictactoe.views.View;

/**
 * Abstract class for the application's state.
 */
public abstract class ApplicationState implements IApplicationState {
    
  /**
   * {@inheritDoc}
   */
  @Override
  public void onStateInitialize() {
      getView().initialize(this);
  }
    
  /**
   * {@inheritDoc}
   */
  @Override
  public void onStateDestroy() {
      getView().clear();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public abstract View getView();
  
}
