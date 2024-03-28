/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.gamemenu.tictactoemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 *
 * @author vitya
 */
public class TicTacToeNewGameOption implements IMenuOption {
    public TicTacToeNewGameOption()
    {}
    
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InInitializeGameMenu());
    }

    @Override
    public String getTitle() {
        return "New Game";
    }
}
