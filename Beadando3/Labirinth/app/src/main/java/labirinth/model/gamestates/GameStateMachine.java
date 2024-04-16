/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitya
 */
public class GameStateMachine {
    private GameStateBase currentState;
    private final List<IGameStateListener> gameStateListeners;
    
    public GameStateMachine()
    {
        this.gameStateListeners = new ArrayList<>();
        this.currentState = null;
    }
    
    public void addGameStateListener(IGameStateListener listener)
    {
        gameStateListeners.add(listener);
    }
    
    public void changeState(GameStateBase newState)
    {
        currentState = newState;
        for(IGameStateListener listener : gameStateListeners)
        {
            listener.onGameStateChanged(currentState);
        }
    }
}
