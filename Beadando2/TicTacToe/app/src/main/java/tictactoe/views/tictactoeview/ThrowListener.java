package tictactoe.views.tictactoeview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.applicationstates.TicTacToe;

/**
 * ActionListener implementation for handling throw actions in the Tic Tac Toe game.
 */
public class ThrowListener implements ActionListener {

    private final TicTacToe game; // Reference to the Tic Tac Toe game instance
    private final int column; // Column number associated with this listener

    /**
     * Constructs a new instance of ThrowListener.
     * @param game The Tic Tac Toe game instance.
     * @param column The column number associated with this listener.
     */
    public ThrowListener(TicTacToe game, int column) {
        this.game = game; // Initialize game reference
        this.column = column; // Initialize column number
    }

    /**
     * Called when an action (such as a button click) is performed.
     * It throws a token with the current player at the specified column.
     * @param e The ActionEvent object representing the action performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        game.throwWithCurrentPlayerAt(column); // Call throwWithCurrentPlayerAt method on the Tic Tac Toe game instance
    }
}
