package tictactoe.gamemenu.tictactoemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 * Represents the "Menu" option in the Tic Tac Toe game menu.
 */
public class TicTacToeMenuOption implements IMenuOption {
    
    /**
     * Constructs a new instance of the TicTacToeMenuOption class.
     */
    public TicTacToeMenuOption() {
        // Constructor
    }
    
    /**
     * Performs the action associated with selecting the "Menu" option.
     * Changes the application state to the main menu state.
     */
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InMainMenu());
    }

    /**
     * Gets the title of the "Menu" option.
     * @return The title of the option, which is "Menu".
     */
    @Override
    public String getTitle() {
        return "Menu";
    }
    
}
