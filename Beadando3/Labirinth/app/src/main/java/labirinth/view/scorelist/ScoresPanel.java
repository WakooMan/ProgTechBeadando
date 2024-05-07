package labirinth.view.scorelist;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import labirinth.model.gamestates.Scores;
import labirinth.model.utilities.ScoreDto;
import labirinth.view.CardPanel;

/**
 * Panel for displaying the scores.
 * This panel shows the top scores and provides a button to return to the main menu.
 * It handles retrieving scores from the database and displaying them in a list.
 */
public class ScoresPanel extends CardPanel<Scores> {

    private final JButton menuButton;
    private final ScoreList scoreList;
    private ActionListener menuAction;
    
    /**
     * Constructs a new ScoresPanel.
     * Initializes the components and sets up the layout.
     */
    public ScoresPanel() {
        super();
        setBackground(Color.BLACK);
        menuButton = new JButton("Menu");
        scoreList = new ScoreList(10);
        menuAction = null;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.weightx = 0.2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel label = new JLabel("SCORES", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label, gbc);
        gbc.weighty = 0.5;
        gbc.gridy = 1;
        add(scoreList, gbc);
        gbc.gridy = 2;
        gbc.weighty = 0.3;
        modifyButton(menuButton, gbc);
    }
    
    /**
     * Callback method invoked when the scores card is shown.
     * Retrieves scores from the database and updates the score list.
     * Handles exceptions if scores cannot be retrieved.
     * 
     * @param gameState The Scores state providing necessary information.
     */
    @Override
    public void onCardShow(Scores gameState) {
        menuAction = (e) -> {
            gameState.backToMenu();
        };
        menuButton.addActionListener(menuAction);
        try {
            for (ScoreDto score : gameState.getScores()) {
                scoreList.addScore(score);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane optionPane = new JOptionPane("Could not get scores from the database!", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning!");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }

    /**
     * Callback method invoked when the scores card is not shown.
     * Removes action listeners and clears the score list.
     */
    @Override
    public void onCardNotShown() {
        menuButton.removeActionListener(menuAction);
        menuAction = null;
        scoreList.clear();
    }

    /**
     * Gets the name of the view.
     * 
     * @return The name of the view.
     */
    @Override
    public String getViewName() {
        return Scores.class.getName();
    }
    
    /**
     * Modifies the appearance of a button.
     * 
     * @param button The button to modify.
     * @param c The constraints to apply.
     */
    private void modifyButton(JButton button, GridBagConstraints c) {
        // Set button size
        button.setBackground(Color.gray); // Set button background color
        button.setFont(new Font("Arial", Font.PLAIN, 20)); // Set button font
        add(button, c); // Add button to the view
    }
    
}
