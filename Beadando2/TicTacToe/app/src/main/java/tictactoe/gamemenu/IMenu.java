package tictactoe.gamemenu;

import java.util.*;

/**
 * Abstract interface for menu.
 */
public interface IMenu {

    /**
     * Gets the menu options.
     * @return menu options.
     */
    public List<IMenuOption> getOptions();

    /**
     * Invokes the doOption method of the index. menu option.
     * @param index 
     */
    public void doOption(int index);

}