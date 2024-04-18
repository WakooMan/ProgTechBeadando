/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

/**
 *
 * @author vitya
 */
public class Scores extends GameStateBase{
    
    public Scores(GameStateMachine stateMachine) {
        super(stateMachine);
    }
    
    public void BackToMenu()
    {
        this.stateMachine.changeState(new MainMenu(stateMachine));
    }
    
}
