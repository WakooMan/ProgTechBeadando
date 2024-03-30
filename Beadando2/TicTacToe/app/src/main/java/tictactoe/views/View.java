package tictactoe.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import tictactoe.applicationstates.IApplicationState;

/**
 * Abstract class representing a view in the Tic Tac Toe game.
 * @param <T> The type of application state associated with the view.
 */
public abstract class View<T extends IApplicationState> extends JPanel {
    
    /**
     * Constructs a new instance of the View class with the specified layout manager.
     * @param layout The layout manager for the view.
     */
    protected View(LayoutManager layout) {
        super(layout);
        setPreferredSize(new Dimension(1280, 1024)); // Set preferred size
        setBackground(Color.yellow); // Set background color
    }
    
    /**
     * Constructs a new instance of the View class with the default constructor.
     * Default constructor sets no layout manager.
     */
    protected View() {
        super();
        setPreferredSize(new Dimension(1280, 1024)); // Set preferred size
        setBackground(Color.yellow); // Set background color
    }
    
    /**
     * Initializes the view with the specified application state.
     * @param state The application state to initialize the view with.
     */
    public abstract void initialize(T state);
    
    /**
     * Clears the view, resetting it to its initial state.
     */
    public abstract void clear();
    
    /**
     * Gets the name of the view.
     * @return The name of the view.
     */
    public abstract String getViewName();
    
}
