package tictactoe.views.mainmenu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import tictactoe.gamemenu.IMenuOption;

public class MainMenuButton extends JPanel implements ActionListener {
    private final JButton button;
    private final IMenuOption menuOption;
    
    public MainMenuButton(IMenuOption menuOption)
    {
        super(new FlowLayout(FlowLayout.CENTER));
        this.menuOption = menuOption;
        button = new JButton(menuOption.getTitle());
        button.addActionListener(this);
        button.setSize(100, 100);
        add(button);
        setSize(100,100);
        setBorder(new EmptyBorder(50,0,50,0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuOption.doOption();
    }
    
}
