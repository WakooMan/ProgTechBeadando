package tictactoe.gamemenu.initializegamemenu;

import javax.swing.JOptionPane;
import tictactoe.ObjectCompositionUtils;
import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.applicationstates.TicTacToe;
import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.MainWindow;

/**
 * Represents the "Start" option in the game menu.
 */
public class StartOption implements IMenuOption{
    private final InInitializeGameMenu gameMenu;
    private final IMatchFactory matchFactory;
    
    /**
     * Constructs a new instance of the StartOption class.
     * @param gameMenu The state representing the initialized game menu.
     */
    public StartOption(InInitializeGameMenu gameMenu) 
    {
        this.gameMenu = gameMenu;
        // Get the default match factory using object composition
        this.matchFactory = ObjectCompositionUtils.getDefaultMatchFactory();
    }
    
    /**
     * Performs the action associated with selecting the "Start" option.
     * Checks if inputs are valid and starts the game accordingly.
     */
    @Override
    public void doOption() {
        // Check if inputs are invalid
        if(gameMenu.areInputsInvalid())
        {
            // Display message indicating inputs are invalid
            JOptionPane.showMessageDialog(MainWindow.getInstance(), "Cannot start the game, because some inputs are still invalid.");
        }
        else
        {
            // Create a new TicTacToe state and change the application state
            ApplicationStateManager.getInstance().changeState(new TicTacToe(matchFactory.create(gameMenu.getMatchName(), gameMenu.getColumnNum(), gameMenu.getRowNum(), gameMenu.getPlayer1(), gameMenu.getPlayer2())));
        }
    }

    /**
     * Gets the title of the "Start" option.
     * @return The title of the option, which is "Start".
     */
    @Override
    public String getTitle() {
        return "Start";
    }
}
