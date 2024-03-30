package tictactoe.applicationstates;

import tictactoe.views.View;

/**
 * Abstract interface for the application's state.
 */
public interface IApplicationState {
    
  /**
   * Gets the View object of the application state.
   * @return View object
   */
  public View getView();
  
  /**
   * Called, when current state is changed to this state.
   */
  public void onStateInitialize();
  
   /**
   * Called, when current state is changed from this state.
   */
  public void onStateDestroy();

}