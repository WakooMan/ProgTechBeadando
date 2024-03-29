package tictactoe.views.mainmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import tictactoe.views.MenuButton;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.View;

public class MainMenuView extends View<InMainMenu>{
    public MainMenuView()
    {
        super();
        setLayout(new GridBagLayout());
    }

    @Override
    public void initialize(InMainMenu state) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.5;
        for(IMenuOption menuOption : state.getMainMenu().getOptions())
        {
            MenuButton button = new MenuButton(menuOption);
            button.setPreferredSize(new Dimension(800, 200));
            button.setBackground(Color.cyan);
            button.setFont(new Font("Arial", Font.PLAIN, 50));
            this.add(button, c);
            c.gridy++;
        }
    }

    @Override
    public void clear() {
        this.removeAll();
    }

    @Override
    public String getViewName() {
        return "MainMenuView";
    }
    
}