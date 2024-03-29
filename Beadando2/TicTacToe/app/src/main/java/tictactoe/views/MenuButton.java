package tictactoe.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import tictactoe.gamemenu.IMenuOption;

public class MenuButton extends JButton implements ActionListener {
    private final IMenuOption menuOption;
    
    public MenuButton(IMenuOption menuOption)
    {
        super(menuOption.getTitle());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.menuOption = menuOption;
        this.addActionListener(this);
        setBorder(new EmptyBorder(50,0,50,0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuOption.doOption();
    }
    
}
