package tictactoe.views.initializegameview;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.View;
import tictactoe.views.mainmenu.MainMenuButton;

public class InitializeGameView extends View<InInitializeGameMenu> {
    
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    
    public InitializeGameView()
    {
        super(new GridBagLayout());
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        add(topPanel);
        add(bottomPanel);
    }

    @Override
    public void initialize(InInitializeGameMenu state) {
        
        for(IMenuOption menuOption : state.getInitializeGameMenu().getOptions())
        {
            bottomPanel.add(new MainMenuButton(menuOption));
        }
    }

    @Override
    public void clear() {
        topPanel.removeAll();
        bottomPanel.removeAll();
    }

    @Override
    public String getViewName() {
        return "InitializeGameView";
    }
    
    
}