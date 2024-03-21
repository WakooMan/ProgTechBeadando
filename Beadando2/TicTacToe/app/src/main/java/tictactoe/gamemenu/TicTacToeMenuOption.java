/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.gamemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InGameMenu;
import tictactoe.gamecontrol.Match;

/**
 *
 * @author vitya
 */
public class TicTacToeMenuOption implements IMenuOption {

    private final Match match;
    
    public TicTacToeMenuOption(Match match)
    {
        this.match = match;
    }
    
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InGameMenu(match));
    }

    @Override
    public String getTitle() {
        return "GameMenu";
    }
    
}
