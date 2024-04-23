/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

/**
 *
 * @author vitya
 */
public class MainMenu extends GameStateBase {

    public MainMenu(GameStateMachine stateMachine) {
        super(stateMachine);
    }

    public void startGame() {
        this.stateMachine.changeState(new StartGame(stateMachine));
    }
    
    public void scoresList()
    {
        this.stateMachine.changeState(new Scores(stateMachine));
    }

    public void exitGame() {
        System.exit(0);
    }
    
}
