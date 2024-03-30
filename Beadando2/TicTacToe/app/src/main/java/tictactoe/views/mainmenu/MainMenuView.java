package tictactoe.views.mainmenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import tictactoe.views.MenuButton;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.View;

/**
 * Represents the view for the main menu of the Tic Tac Toe application.
 */
public class MainMenuView extends View<InMainMenu> {

    /**
     * Constructs a new instance of the MainMenuView class.
     */
    public MainMenuView() {
        super();
        setLayout(new GridBagLayout()); // Set layout to GridBagLayout
    }

    /**
     * Initializes the main menu view with the specified application state.
     * @param state The application state to initialize the view with.
     */
    @Override
    public void initialize(InMainMenu state) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.5;
        // Iterate through menu options and create buttons for each
        for (IMenuOption menuOption : state.getMainMenu().getOptions()) {
            MenuButton button = new MenuButton(menuOption); // Create menu button
            button.setPreferredSize(new Dimension(800, 200)); // Set button size
            button.setBackground(Color.cyan); // Set button background color
            button.setFont(new Font("Arial", Font.PLAIN, 50)); // Set button font
            this.add(button, c); // Add button to the view
            c.gridy++; // Move to next row
        }
    }

    /**
     * Clears the main menu view, resetting it to its initial state.
     */
    @Override
    public void clear() {
        this.removeAll(); // Remove all components from the view
    }

    /**
     * Gets the name of the main menu view.
     * @return The name of the view.
     */
    @Override
    public String getViewName() {
        return "MainMenuView"; // Return the name of the view
    }
}
