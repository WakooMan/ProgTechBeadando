package tictactoe.views.tictactoeview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tictactoe.applicationstates.TicTacToe;
import tictactoe.gamecontrol.Player;
import tictactoe.views.View;
import tictactoe.views.mainmenu.MainMenuButton;

public class TicTacToeGameView extends View<TicTacToe>{

    private JPanel topPanel;
    private JPanel bottomPanel;
    
    public TicTacToeGameView()
    {
        super();
        setLayout(new GridBagLayout());
    }
    
    @Override
    public void initialize(TicTacToe state) {
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 50));
        bottomPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        bottomPanel.setLayout(new GridLayout(state.getM() + 1, state.getN()));
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.2;
        add(topPanel, c);
        c.gridy = 1;
        c.gridx = 0;
        c.weighty = 1.5;
        c.fill = GridBagConstraints.BOTH;
        add(bottomPanel, c);
        
        topPanel.add(new MainMenuButton(state.getGameMenuOption()));
        for(Player player : state.getPlayers())
        {
            topPanel.add(new PlayerPanel(player, state.getCurrentPlayer() == player));
        }
        
        for(int i=0; i < state.getN() ; i++)
        {
            ThrowButton throwButton = new ThrowButton(new ThrowListener(state, i));
            bottomPanel.add(throwButton);
        }
        for(int i=0; i < state.getM() ; i++)
        {
            for(int j=0; j < state.getN() ; j++)
            {
                FieldButton button = new FieldButton(state.getField(j, i));
                bottomPanel.add(button);
            }
        }
    }

    @Override
    public void clear() {
        removeAll();
    }

    @Override
    public String getViewName() {
        return "TicTacToeGameView";
    }
    
}
