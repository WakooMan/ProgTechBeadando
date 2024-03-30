package tictactoe.views.tictactoeview;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import tictactoe.table.Field;
import tictactoe.table.Signal;

/**
 * Represents a button that corresponds to a field in the Tic Tac Toe game.
 */
public class FieldButton extends JButton {
    
    // Mapping from signals to their corresponding display text
    private final static HashMap<Signal, String> signalMap = new HashMap<>() {{
        put(Signal.Empty, ""); // Empty field
        put(Signal.X, "X");   // Field with X
        put(Signal.O, "O");   // Field with O
    }};
    
    /**
     * Constructs a new instance of the FieldButton class.
     * @param field The field corresponding to this button.
     */
    public FieldButton(Field field) {
        // Set properties of the button
        setEnabled(false);                // Disable the button
        setBackground(Color.white);       // Set background color to white
        setBorder(new LineBorder(Color.black));  // Set border color to black
        
        // Add a listener to the field to update the button text when the signal changes
        field.addListener((signal) -> setText(signalMap.get(signal)));
    }
}
