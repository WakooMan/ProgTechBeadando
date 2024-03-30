package tictactoe.gamemenu.initializegamemenu;

import java.util.ArrayList;
import java.util.List;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenu;
import tictactoe.gamemenu.IMenuOption;

/**
 * Represents the menu for initializing the game settings.
 */
public class InitializeGameMenu implements IMenu {
    // List to hold menu options
    private final List<IMenuOption> gameMenuOptions;

    /**
     * Constructs a new instance of the InitializeGameMenu class.
     * @param gameMenu The state representing the initialized game menu.
     */
    public InitializeGameMenu(InInitializeGameMenu gameMenu) {
        this.gameMenuOptions = new ArrayList<>();
        // Add menu options
        this.gameMenuOptions.add(new BackOption());
        this.gameMenuOptions.add(new StartOption(gameMenu));
    }

    /**
     * Retrieves the list of menu options.
     * @return The list of menu options.
     */
    @Override
    public List<IMenuOption> getOptions() {
        return gameMenuOptions;
    }

    /**
     * Performs the action associated with the selected menu option.
     * @param index The index of the selected option.
     */
    @Override
    public void doOption(int index) {
        this.gameMenuOptions.get(index).doOption();
    }
}
