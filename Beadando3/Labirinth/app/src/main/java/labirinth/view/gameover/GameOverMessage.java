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
 * Represents a panel displaying game over message and options.
 */
public class GameOverMessage extends JPanel {
    
    private final JLabel gameOverMessage;
    private final JLabel mapCountMessage;
    private final JButton backToMenu;
    private final JButton scoresList;

    /**
     * Constructs a new GameOverMessage panel.
     * 
     * @param gameState The game over state containing necessary information.
     */
    public GameOverMessage(GameOver gameState) {
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
    
    /**
     * Adds action listeners to buttons.
     * 
     * @param gameState The game over state providing action methods.
     */
    private void addListeners(GameOver gameState) {
        backToMenu.addActionListener((e) -> {
            gameState.goToMenu();
        });
        scoresList.addActionListener((e) -> {
            gameState.goToScores();
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Component c = (Component) evt.getSource();
                sizeComponents(c);
            }
        });
    }
    
    /**
     * Sizes the components based on the panel's size.
     * 
     * @param c The component to be sized.
     */
    private void sizeComponents(Component c) {
        Font font = new Font("Arial", Font.PLAIN, c.getHeight() / 4);
        Dimension labelSize = new Dimension(c.getWidth(), c.getHeight() / 4);
        gameOverMessage.setFont(font);
        gameOverMessage.setSize(labelSize);
        mapCountMessage.setFont(font);
        mapCountMessage.setSize(labelSize);
        Dimension buttonSize = new Dimension(getWidth() / 2, getHeight() / 2);
        backToMenu.setSize(buttonSize);
        backToMenu.setFont(font);
        scoresList.setSize(buttonSize);
        scoresList.setFont(font);
        repaint();
    }
    
    /**
     * Adds components to the panel.
     */
    private void addControls() {
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
