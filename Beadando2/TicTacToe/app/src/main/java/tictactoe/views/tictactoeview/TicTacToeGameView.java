package tictactoe.views.tictactoeview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tictactoe.applicationstates.TicTacToe;
import tictactoe.gamecontrol.MatchListener;
import tictactoe.gamecontrol.Player;
import tictactoe.views.View;
import tictactoe.views.MenuButton;

/**
 * Represents the view for the Tic Tac Toe game.
 */
public class TicTacToeGameView extends View<TicTacToe>{

    private final List<ThrowButton> throwButtons;
    
    /**
     * Constructs a new instance of TicTacToeGameView.
     */
    public TicTacToeGameView()
    {
        super();
        throwButtons = new ArrayList<>();
        setLayout(new GridBagLayout());
    }
    
    /**
     * Initializes the Tic Tac Toe game view with the specified state.
     * @param state The Tic Tac Toe game state.
     */
    @Override
    public void initialize(TicTacToe state) {
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBackground(this.getBackground());
        MenuButton menuButton = new MenuButton(state.getMenuOption());
        menuButton.setPreferredSize(new Dimension(100, 30));
        menuButton.setBackground(Color.cyan);
        menuPanel.add(menuButton);
        MenuButton newGameButton = new MenuButton(state.getNewGameOption());
        newGameButton.setBackground(Color.cyan);
        newGameButton.setPreferredSize(new Dimension(100, 30));
        menuPanel.add(newGameButton);
        JPanel playersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        playersPanel.setBackground(this.getBackground());
        for(Player player : state.getPlayers())
        {
            PlayerPanel panel = new PlayerPanel(player, state.getCurrentPlayer() == player);
            panel.setPreferredSize(new Dimension(300, 80));
            panel.setFont(new Font("Arial", Font.PLAIN, 50));
            playersPanel.add(panel);
        }
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(this.getBackground());
        bottomPanel.setLayout(new GridLayout(state.getRowNum() + 1, state.getColumnNum()));
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1;
        c.weighty = 2;
        c.fill = GridBagConstraints.BOTH;
        add(menuPanel, c);
        c.weighty = 18;
        c.gridy = 1;
        add(playersPanel, c);
        c.gridy = 2;
        c.weighty = 80;
        add(bottomPanel, c);
        
        for(int i=0; i < state.getColumnNum() ; i++)
        {
            ThrowButton throwButton = new ThrowButton(new ThrowListener(state, i));
            throwButtons.add(throwButton);
            bottomPanel.add(throwButton);
        }
        for(int i=0; i < state.getRowNum() ; i++)
        {
            for(int j=0; j < state.getColumnNum() ; j++)
            {
                FieldButton button = new FieldButton(state.getField(j, i));
                button.setFont(new Font("Arial", Font.PLAIN, 400/Math.min(state.getColumnNum(), state.getRowNum())));
                bottomPanel.add(button);
            }
        }
        
        state.addMatchListener(new MatchListener() {
        @Override
        public void onGameOver(Player player)
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
        }
        
        @Override
        public void onColumnFilled(int column)
        {
            throwButtons.get(column).onColumnFilled();
        }
        
        @Override
        public void onColumnCleared(int column)
        {
            throwButtons.get(column).onColumnCleared();
        }
        
        });
    }

    /**
     * Clears the Tic Tac Toe game view.
     */
    @Override
    public void clear() {
        removeAll();
        throwButtons.clear();
    }

    /**
     * Gets the name of the Tic Tac Toe game view.
     * @return The name of the view.
     */
    @Override
    public String getViewName() {
        return "TicTacToeGameView";
    }
    
}
