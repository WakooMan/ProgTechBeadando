package tictactoe.views.tictactoeview;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Represents a button used for throwing the token in the Tic Tac Toe game.
 */
public class ThrowButton extends JButton {
    
    /**
     * Constructs a new instance of the ThrowButton class.
     * @param actionListener The ActionListener to handle button clicks.
     */
    public ThrowButton(ActionListener actionListener) {
        super(); // Call superclass constructor
        addActionListener(actionListener); // Add action listener to handle button clicks
        setBackground(Color.cyan); // Set background color
        this.setBorder(new LineBorder(Color.GREEN, 5)); // Set border color and thickness
        setInvisible(); // Set button initially invisible
        // Add mouse listener to show button when mouse hovers over
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setVisible(); // Show button
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setInvisible(); // Hide button
            }
        });
    }
    
    /**
     * Disables the button and changes its appearance when the corresponding column is filled.
     */
    public void onColumnFilled() {
        setEnabled(false); // Disable button
        setBorder(new LineBorder(Color.RED, 5)); // Change border color to indicate filled column
        setInvisible(); // Hide button
    }
    
    /**
     * Enables the button and restores its appearance when the corresponding column is cleared.
     */
    public void onColumnCleared() {
        setEnabled(true); // Enable button
        setBorder(new LineBorder(Color.GREEN, 5)); // Restore original border color
    }
    
    /**
     * Makes the button visible if it is enabled.
     */
    private void setVisible() {
        if (this.isEnabled()) { // Check if button is enabled
            setContentAreaFilled(true); // Make button visible
        }
    }
    
    /**
     * Makes the button invisible.
     */
    private void setInvisible() {
        setContentAreaFilled(false); // Make button invisible
    }
}
