package tictactoe.gamemenu.initializegamemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 * Represents the "Back" option in the game menu.
 */
public class BackOption implements IMenuOption {

    /**
     * Constructs a new instance of the BackOption class.
     */
    public BackOption() {
        // Constructor
    }
    
    /**
     * Performs the action associated with selecting the "Back" option,
     * which changes the application state to the main menu state.
     */
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InMainMenu());
    }

    /**
     * Gets the title of the "Back" option.
     * @return The title of the option, which is "Back".
     */
    @Override
    public String getTitle() {
        return "Back";
    }
    
}
