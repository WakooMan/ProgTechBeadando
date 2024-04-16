/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamestates;

/**
 *
 * @author vitya
 */
public class StartGame extends GameStateBase {

    public StartGame(GameStateMachine stateMachine) {
        super(stateMachine);
    }

    public void startGame(String playerName) {
        this.stateMachine.changeState(new PlayingGame(stateMachine, playerName));
    }

    public void backToMainMenu() {
        this.stateMachine.changeState(new MainMenu(stateMachine));
    }
    
}
