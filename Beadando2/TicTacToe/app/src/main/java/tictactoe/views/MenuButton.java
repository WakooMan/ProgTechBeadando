package tictactoe.views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import tictactoe.gamemenu.IMenuOption;

/**
 * Represents a button used in the menu view of the Tic Tac Toe game.
 */
public class MenuButton extends JButton implements ActionListener {
    // The menu option associated with the button
    private final IMenuOption menuOption;
    
    /**
     * Constructs a new instance of the MenuButton class.
     * @param menuOption The menu option associated with the button.
     */
    public MenuButton(IMenuOption menuOption) {
        super(menuOption.getTitle()); // Set button text to menu option title
        this.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set button layout
        this.menuOption = menuOption; // Store the menu option
        this.addActionListener(this); // Add action listener to handle button clicks
        setBorder(new EmptyBorder(50,0,50,0)); // Set button border
    }

    /**
     * Handles the action performed event when the button is clicked.
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Perform the menu option action when the button is clicked
        menuOption.doOption();
    }
}
