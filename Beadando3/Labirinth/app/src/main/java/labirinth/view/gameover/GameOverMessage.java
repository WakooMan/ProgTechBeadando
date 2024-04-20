/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.gameover;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import labirinth.model.gamestates.GameOver;

/**
 *
 * @author Viktor
 */
public class GameOverMessage extends JPanel {
    private final JLabel gameOverMessage;
    private final JLabel mapCountMessage;
    private final JButton backToMenu;
    private final JButton scoresList;
    
    public GameOverMessage(GameOver gameState)
    {
        super();
        gameOverMessage = new JLabel(gameState.getGameOverMessage(), JLabel.CENTER);
        mapCountMessage = new JLabel(gameState.getCompletedMapsMessage(), JLabel.CENTER);
        backToMenu = new JButton("Menu");
        scoresList = new JButton("Scores");
        setBackground(Color.lightGray);
        gameOverMessage.setForeground(Color.BLACK);
        mapCountMessage.setForeground(Color.BLACK);
        backToMenu.setBackground(Color.BLACK);
        scoresList.setBackground(Color.BLACK);
        backToMenu.setForeground(Color.WHITE);
        scoresList.setForeground(Color.WHITE);
        setLayout(new GridBagLayout());
        addListeners(gameState);
        addControls();
        sizeComponents(this);
    }
    
    private void addListeners(GameOver gameState)
    {
        backToMenu.addActionListener((e) ->
        {
            gameState.GoToMenu();
        });
        scoresList.addActionListener((e) ->
        {
            gameState.GoToScores();
        });
        addComponentListener(new ComponentAdapter() 
        {
            @Override
            public void componentResized(ComponentEvent evt) {
            Component c = (Component)evt.getSource();
            sizeComponents(c);
            }
        });
    }
    
    private void sizeComponents(Component c)
    {
        Font font = new Font("Arial", Font.PLAIN, c.getHeight()/4);
        Dimension labelSize = new Dimension(c.getWidth(), c.getHeight()/4);
        gameOverMessage.setFont(font);
        gameOverMessage.setSize(labelSize);
        mapCountMessage.setFont(font);
        mapCountMessage.setSize(labelSize);
        Dimension buttonSize = new Dimension(getWidth()/2, getHeight()/2);
        backToMenu.setSize(buttonSize);
        backToMenu.setFont(font);
        scoresList.setSize(buttonSize);
        scoresList.setFont(font);
        repaint();
    }
    
    private void addControls()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(gameOverMessage, gbc);
        gbc.gridy = 1;
        add(mapCountMessage, gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(backToMenu, gbc);
        gbc.gridx = 1;
        add(scoresList, gbc);
    }
}
