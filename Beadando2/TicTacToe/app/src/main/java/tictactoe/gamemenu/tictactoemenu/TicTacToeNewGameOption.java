package tictactoe.gamemenu.tictactoemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 * Represents the "New Game" option in the Tic Tac Toe game menu.
 */
public class TicTacToeNewGameOption implements IMenuOption {
    
    /**
     * Constructs a new instance of the TicTacToeNewGameOption class.
     */
    public TicTacToeNewGameOption() {
        // Constructor
    }
    
    /**
     * Performs the action associated with selecting the "New Game" option.
     * Changes the application state to the initialized game menu state.
     */
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InInitializeGameMenu());
    }

    /**
     * Gets the title of the "New Game" option.
     * @return The title of the option, which is "New Game".
     */
    @Override
    public String getTitle() {
        return "New Game";
    }
}
