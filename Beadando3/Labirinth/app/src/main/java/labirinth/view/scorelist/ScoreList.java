/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.scorelist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import labirinth.model.utilities.ScoreDto;

/**
 *
 * @author Viktor
 */
public class ScoreList extends JPanel {
 
    private final int height;
    private int currentHeight;
    private final JButton[] nameLabels;
    private final JButton[] scoreLabels;
    
    
    public ScoreList(int height)
    {
        super(new GridLayout(height, 2));
        this.setBackground(Color.gray);
        this.height = height;
        nameLabels = new JButton[height];
        scoreLabels = new JButton[height];
        currentHeight = 0;
        for(int i=0;i< height; i++)
        {
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
    
    public void addScore(ScoreDto score)
    {
        if(currentHeight < height)
        {
            nameLabels[currentHeight].setText(score.getPlayerName());
            scoreLabels[currentHeight].setText(Integer.toString(score.getScore()));
            currentHeight++;
        }
    }
    
    public void clear()
    {
        removeAll();
        currentHeight = 0;
    }
    
    
}
