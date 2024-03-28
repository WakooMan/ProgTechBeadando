package tictactoe.views.tictactoeview;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
        bottomPanel.setLayout(new GridLayout(state.getRowNum() + 1, state.getColumnNum()));
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
        
        topPanel.add(new MainMenuButton(state.getMenuOption()));
        topPanel.add(new MainMenuButton(state.getNewGameOption()));
        for(Player player : state.getPlayers())
        {
            topPanel.add(new PlayerPanel(player, state.getCurrentPlayer() == player));
        }
        
        for(int i=0; i < state.getColumnNum() ; i++)
        {
            ThrowButton throwButton = new ThrowButton(new ThrowListener(state, i));
            bottomPanel.add(throwButton);
        }
        for(int i=0; i < state.getRowNum() ; i++)
        {
            for(int j=0; j < state.getColumnNum() ; j++)
            {
                FieldButton button = new FieldButton(state.getField(j, i));
                bottomPanel.add(button);
            }
        }
        
        state.addMatchListener((player)-> 
        {
            String message;
            if(player == null)
            {
                message = "Draw!";
            }
            else
            {
                message = "Winner: " + player.getName();
            }
            
            JOptionPane pane = new JOptionPane(message, JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog(null, "Game Over!");
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.setVisible(true);
            
            int value = (Integer)pane.getValue();
            if (value == JOptionPane.OK_OPTION) {
                state.clearMatch();
                } 
        });
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
