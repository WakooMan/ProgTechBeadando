package tictactoe.views;

import java.awt.LayoutManager;
import javax.swing.JPanel;
import tictactoe.applicationstates.IApplicationState;

public abstract class View<T extends IApplicationState> extends JPanel {
    
    protected View(LayoutManager layout)
    {
        super(layout);
        setSize(500,500);
    }
    
    protected View()
    {
        super();
        setSize(500,500);
    }
    
    public abstract void initialize(T state);
    
    public abstract void clear();
    
    public abstract String getViewName();
    
}
