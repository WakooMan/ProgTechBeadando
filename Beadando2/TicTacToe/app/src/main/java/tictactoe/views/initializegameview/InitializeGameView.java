package tictactoe.views.initializegameview;

import java.awt.Color;
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
import tictactoe.views.mainmenu.MainMenuButton;

public class InitializeGameView extends View<InInitializeGameMenu> {
    
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    
    public InitializeGameView()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        add(topPanel);
        add(bottomPanel);
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
        mtf.setText("4");
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.add(ntf);
        sizePanel.add(new JLabel(" X "));
        sizePanel.add(mtf);
        
        topPanel.add(new JLabel("Match Name"));
        topPanel.add(matchNametf);
        topPanel.add(new JLabel("Table size"));
        topPanel.add(sizePanel);
        topPanel.add(new JLabel("Player 1"));
        topPanel.add(player1tf);
        topPanel.add(new JLabel("Player 2"));
        topPanel.add(player2tf);
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