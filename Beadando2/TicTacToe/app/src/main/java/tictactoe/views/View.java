package tictactoe.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import tictactoe.applicationstates.IApplicationState;

public abstract class View<T extends IApplicationState> extends JPanel {
    
    protected View(LayoutManager layout)
    {
        super(layout);
        setPreferredSize(new Dimension(1280, 1024));
        setBackground(Color.yellow);
    }
    
    protected View()
    {
        super();
        setPreferredSize(new Dimension(1280, 1024));
        setBackground(Color.yellow);
    }
    
    public abstract void initialize(T state);
    
    public abstract void clear();
    
    public abstract String getViewName();
    
}
