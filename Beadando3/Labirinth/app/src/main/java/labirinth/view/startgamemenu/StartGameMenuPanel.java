package labirinth.view.startgamemenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import labirinth.model.gamestates.StartGame;
import labirinth.view.CardPanel;

/**
 * Panel for displaying the start game menu.
 * This panel provides a text field for entering the player's name, a start button, and a back button.
 * It also validates the player's name and enables/disables the start button accordingly.
 */
public class StartGameMenuPanel extends CardPanel<StartGame> {

    private final JButton start;
    private final JButton back;
    private ActionListener startAction;
    private ActionListener backAction;
    private final JTextField nameField;
    private static final String STR_REGEX_PATTERN = "^[A-Za-z0-9.]{1,255}$";
    
    /**
     * Constructs a new StartGameMenuPanel.
     * Initializes the components and sets up the layout.
     */
    public StartGameMenuPanel() {
        super();
        start = new JButton("START");
        back = new JButton("BACK");
        nameField = new JTextField(20);
        setDefaultState();
        nameField.getDocument().addDocumentListener(new JTextFieldListener(nameField, (field) -> {
            String player = field.getText();
            if (player.length() >= 3 && player.matches(STR_REGEX_PATTERN)) {
                field.setBorder(new LineBorder(Color.green, 1));
                start.setEnabled(true);
            } else {
                field.setBorder(new LineBorder(Color.red, 1));
                start.setEnabled(false);
            }
        }));
        modifyButton(start);
        modifyButton(back);
        modifyTextField(nameField);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(nameField, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(back, gbc);
        gbc.gridx = 1;
        panel.add(start, gbc);
        add(panel);
    }
    
    /**
     * Callback method invoked when the start game menu card is shown.
     * Assigns actions to the start button and the back button.
     * 
     * @param gameState The StartGame state providing necessary information.
     */
    @Override
    public void onCardShow(StartGame gameState) {
        startAction = (e) -> {
            gameState.startGame(nameField.getText());
        };
        backAction = (e) -> {
            gameState.backToMainMenu();
        };
        start.addActionListener(startAction);
        back.addActionListener(backAction);
    }

    /**
     * Callback method invoked when the start game menu card is not shown.
     * Removes action listeners from the buttons and resets the state of the text field and start button.
     */
    @Override
    public void onCardNotShown() {
        if (startAction != null) {
            start.removeActionListener(startAction);
        }
        if (backAction != null) {
            back.removeActionListener(backAction);
        }
        setDefaultState();
    }

    /**
     * Gets the name of the view.
     * 
     * @return The name of the view.
     */
    @Override
    public String getViewName() {
        return StartGame.class.getName();
    }
    
    /**
     * Modifies the appearance of a button.
     * 
     * @param button The button to modify.
     */
    private void modifyButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 50)); // Set button size
        button.setBackground(Color.gray); // Set button background color
        button.setFont(new Font("Arial", Font.PLAIN, 20)); // Set button font
    }
    
    /**
     * Modifies the appearance of a text field.
     * 
     * @param textField The text field to modify.
     */
    private void modifyTextField(JTextField textField) {
        textField.setPreferredSize(new Dimension(300, 100)); // Set text field size
        textField.setBackground(Color.gray); // Set text field background color
        textField.setFont(new Font("Arial", Font.PLAIN, 40)); // Set text field font
        textField.setForeground(Color.BLACK);
    }
    
    /**
     * Resets the state of the text field and start button to default values.
     */
    private void setDefaultState() {
        nameField.setText("");
        nameField.setBorder(new LineBorder(Color.red, 1));
        start.setEnabled(false);
    }
    
}
