/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

/**
 *
 * @author vitya
 */
public abstract class GameStateBase {
    protected final GameStateMachine stateMachine;
    
    protected GameStateBase(GameStateMachine stateMachine)
    {
        this.stateMachine = stateMachine;
    }
}
