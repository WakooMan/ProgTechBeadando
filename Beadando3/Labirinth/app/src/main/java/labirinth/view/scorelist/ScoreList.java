package labirinth.view.scorelist;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import labirinth.model.utilities.ScoreDto;

/**
 * Panel for displaying a list of scores.
 */
public class ScoreList extends JPanel {
 
    private final int height;
    private int currentHeight;
    private final JButton[] nameLabels;
    private final JButton[] scoreLabels;
    
    
    /**
     * Constructs a new ScoreList panel with a specified height.
     * 
     * @param height The height of the score list.
     */
    public ScoreList(int height) {
        super(new GridLayout(height, 2));
        this.setBackground(Color.gray);
        this.height = height;
        nameLabels = new JButton[height];
        scoreLabels = new JButton[height];
        currentHeight = 0;
        for (int i = 0; i < height; i++) {
            Font font = new Font("Arial", Font.PLAIN, 30);
            JButton playerLabel = new JButton("");
            playerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            playerLabel.setFont(font);
            playerLabel.setBackground(Color.gray);
            JButton scoreLabel = new JButton("");
            scoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            scoreLabel.setFont(font);
            scoreLabel.setBackground(Color.gray);
            add(playerLabel);
            add(scoreLabel);
            nameLabels[i] = playerLabel;
            scoreLabels[i] = scoreLabel;
        }
    }
    
    /**
     * Adds a score to the score list.
     * 
     * @param score The score to be added.
     */
    public void addScore(ScoreDto score) {
        if (currentHeight < height) {
            nameLabels[currentHeight].setText(score.getPlayerName());
            scoreLabels[currentHeight].setText(Integer.toString(score.getScore()));
            currentHeight++;
        }
    }
    
    /**
     * Clears the score list.
     */
    public void clear() {
         for (int i = 0; i < height; i++) {
            nameLabels[i].setText("");
            scoreLabels[i].setText("");
        }
        currentHeight = 0;
    }
    
    
}
