package tictactoe.views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuView extends JPanel{
    public MainMenuView()
    {
        this.add(new JButton("Start Game"));
        this.add(new JButton("Load Game"));
        this.add(new JButton("Exit Game"));
        this.setSize(500,500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
}