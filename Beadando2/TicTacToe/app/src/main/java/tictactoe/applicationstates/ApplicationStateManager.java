package tictactoe.applicationstates;

import tictactoe.views.MainWindow;

public class ApplicationStateManager {
    
    private static ApplicationStateManager instance;
    
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
    
    public IApplicationState getCurrentState()
    {
        return currentState;
    }
    
    public void changeState(IApplicationState state)
    {
        currentState.onStateDestroy();
        currentState = state;
        currentState.onStateInitialize();
        MainWindow.getInstance().onViewChanged(currentState.getView());
    }
}
