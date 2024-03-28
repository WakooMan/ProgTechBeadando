/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.gamemenu.tictactoemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 *
 * @author vitya
 */
public class TicTacToeMenuOption implements IMenuOption {
    
    public TicTacToeMenuOption()
    {}
    
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InMainMenu());
    }

    @Override
    public String getTitle() {
        return "Menu";
    }
    
}
