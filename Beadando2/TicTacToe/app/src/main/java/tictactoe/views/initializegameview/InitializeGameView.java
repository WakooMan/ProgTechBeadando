package tictactoe.views.initializegameview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.exceptions.FieldNumberOutOfRangeException;
import tictactoe.exceptions.StringIsNotValidException;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.View;
import tictactoe.views.MenuButton;

public class InitializeGameView extends View<InInitializeGameMenu> {
    
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    private final Font textBoxFont;
    private final Font labelFont;
    
    public InitializeGameView()
    {
        super();
        textBoxFont = new Font("Arial", Font.PLAIN, 30);
        labelFont = new Font("Arial", Font.PLAIN, 50);
        setLayout(new GridBagLayout());
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.8;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(this.getBackground());
        bottomPanel.setLayout(new GridBagLayout());
        bottomPanel.setBackground(this.getBackground());
        add(topPanel, c);
        c.gridy++;
        c.weighty = 0.2;
        add(bottomPanel, c);
    }
    
    @Override
    public void initialize(InInitializeGameMenu state) {
        
        JTextField matchNametf = new JTextField(20);
        matchNametf.getDocument().addDocumentListener(new JTextFieldListener(matchNametf,(field) -> 
        {
            try{
                state.setMatchName(field.getText());
                field.setBorder(new LineBorder(Color.green, 1));
            }catch(StringIsNotValidException ex)
            {
                field.setBorder(new LineBorder(Color.red, 1));
            }
        }));
        matchNametf.setFont(this.textBoxFont);
        matchNametf.setText("MatchName");
        JTextField player1tf = new JTextField(20);
        player1tf.getDocument().addDocumentListener(new JTextFieldListener(player1tf,(field) -> 
        {
            try{
                state.setPlayer1(field.getText());
                field.setBorder(new LineBorder(Color.green, 1));
            }catch(StringIsNotValidException ex)
            {
                field.setBorder(new LineBorder(Color.red, 1));
            }
        }));
        player1tf.setFont(this.textBoxFont);
        player1tf.setText("Player1");
        JTextField player2tf = new JTextField(20);
        player2tf.getDocument().addDocumentListener(new JTextFieldListener(player2tf,(field) -> 
        {
            try{
                state.setPlayer2(field.getText());
                field.setBorder(new LineBorder(Color.green, 1));
            }catch(StringIsNotValidException ex)
            {
                field.setBorder(new LineBorder(Color.red, 1));
            }
        }));
        player2tf.setFont(this.textBoxFont);
        player2tf.setText("Player2");
        JTextField ntf = new JTextField();
        ntf.getDocument().addDocumentListener(new JTextFieldListener(ntf,(field) -> 
        {
            try{
                int number = Integer.parseInt(field.getText());
                state.setN(number);
                field.setBorder(new LineBorder(Color.green, 1));
            }catch(NumberFormatException | FieldNumberOutOfRangeException ex)
            {
                field.setBorder(new LineBorder(Color.red, 1));
            }
            
        }));
        ntf.setFont(this.textBoxFont);
        ntf.setText("4");
        JTextField mtf = new JTextField();
        mtf.getDocument().addDocumentListener(new JTextFieldListener(mtf,(field) -> 
        {
            try{
                int number = Integer.parseInt(field.getText());
                state.setM(number);
                field.setBorder(new LineBorder(Color.green, 1));
            }catch(NumberFormatException | FieldNumberOutOfRangeException ex)
            {
                System.out.println("Set border to red.");
                field.setBorder(new LineBorder(Color.red, 1));
            }
        }));
        mtf.setFont(this.textBoxFont);
        mtf.setText("4");
        JPanel sizePanel = new JPanel();
        sizePanel.setBackground(this.getBackground());
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.add(ntf);
        JLabel xLabel = new JLabel(" X ");
        xLabel.setFont(this.labelFont);
        sizePanel.add(xLabel);
        sizePanel.add(mtf);
        
        JLabel matchLabel = new JLabel("Match Name");
        matchLabel.setFont(this.labelFont);
        topPanel.add(matchLabel);
        topPanel.add(matchNametf);
        JLabel tableLabel = new JLabel("Column Number X Row Number");
        tableLabel.setFont(this.labelFont);
        topPanel.add(tableLabel);
        topPanel.add(sizePanel);
        JLabel player1Label = new JLabel("Player 1");
        player1Label.setFont(this.labelFont);
        topPanel.add(player1Label);
        topPanel.add(player1tf);
        JLabel player2Label = new JLabel("Player 2");
        player2Label.setFont(this.labelFont);
        topPanel.add(player2Label);
        topPanel.add(player2tf);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 1;
        c.weightx = 0.5;
        for(IMenuOption menuOption : state.getInitializeGameMenu().getOptions())
        {
            MenuButton button = new MenuButton(menuOption);
            button.setPreferredSize(new Dimension(100, 50));
            button.setBackground(Color.cyan);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            bottomPanel.add(button, c);
            c.gridx++;
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