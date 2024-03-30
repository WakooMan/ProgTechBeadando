package tictactoe.applicationstates;

import tictactoe.views.MainWindow;

/**
 * Application state manager, which manages the application states.
 * Gets the current state and can change the application state.
 */
public class ApplicationStateManager {
    
    private static ApplicationStateManager instance;
    
    /**
     * Gets the only one instance of ApplicationStateManager.
     * @return instance of ApplicationStateManager.
     */
    public static ApplicationStateManager getInstance()
    {
        if(instance == null)
        {
            instance = new ApplicationStateManager();
        }
        return instance;
    }
    
    private IApplicationState currentState;
    
    private ApplicationStateManager()
    {
        currentState = new InMainMenu();
        currentState.onStateInitialize();
        MainWindow.getInstance().onViewChanged(currentState.getView());
    }
    
    /**
     * Gets the current application state.
     * @return Current application state.
     */
    public IApplicationState getCurrentState()
    {
        return currentState;
    }
    
    /**
     * Changes to the new state, calls onStateDestroy method on 
     * the previous state and onStateInitialize on the new state.
     * @param state New application state.
     */
    public void changeState(IApplicationState state)
    {
        currentState.onStateDestroy();
        currentState = state;
        currentState.onStateInitialize();
        MainWindow.getInstance().onViewChanged(currentState.getView());
    }
}
