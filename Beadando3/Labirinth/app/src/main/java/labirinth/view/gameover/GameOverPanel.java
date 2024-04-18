/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.gameover;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import labirinth.model.gamestates.GameOver;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.view.CardPanel;
import labirinth.view.game.DragonAnimation;
import labirinth.view.game.EntityDrawer;
import labirinth.view.game.IDrawable;
import labirinth.view.game.MapDrawer;
import labirinth.view.game.PlayerAnimation;
import labirinth.view.game.SightDrawer;

/**
 *
 * @author vitya
 */
public class GameOverPanel extends CardPanel<GameOver> {
    private final JPanel gameOver;
    private final JLabel gameOverMessage;
    private final JLabel mapCountMessage;
    private final JButton backToMenu;
    private final JButton scoresList;
    private ActionListener backToMenuAction;
    private ActionListener scoresListAction;
    private IDrawable playerDrawer;
    private IDrawable dragonDrawer;
    private IDrawable mapDrawer;
    private IDrawable sightDrawer;
    
    public GameOverPanel()
    {
        super();
        setLayout(new GridBagLayout());
        setBackground(Color.black);
        gameOverMessage = new JLabel();
        mapCountMessage = new JLabel();
        backToMenu = new JButton("Menu");
        scoresList = new JButton("Scores");
        gameOver = new JPanel();
        gameOver.setBackground(Color.black);
        gameOver.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gameOver.add(gameOverMessage, gbc);
        gbc.gridy = 1;
        gameOver.add(mapCountMessage, gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gameOver.add(backToMenu, gbc);
        gbc.gridx = 1;
        gameOver.add(scoresList, gbc);
        addComponentListener(new ComponentAdapter() 
        {
            @Override
            public void componentResized(ComponentEvent evt) {
            Component c = (Component)evt.getSource();
            MapConfiguration.getInstance().setMapSize(new Position((int)(c.getWidth() * 0.99), c.getHeight()));
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(mapDrawer != null)
        {
            mapDrawer.draw(0, g2);
        }
        if(dragonDrawer != null)
        {
            dragonDrawer.draw(0, g2);
        }
        if(playerDrawer != null)
        {
            playerDrawer.draw(0, g2);
        }
        if(sightDrawer != null)
        {
            sightDrawer.draw(0, g2);
        }
    }
    
    @Override
    public void onCardShow(GameOver gameState) {
        backToMenuAction = (e) ->
        {
            gameState.GoToMenu();
        };
        scoresListAction = (e) ->
        {
            gameState.GoToScores();
        };
        gameOverMessage.setText(gameState.getGameOverMessage());
        mapCountMessage.setText(gameState.getCompletedMapsMessage());
        backToMenu.addActionListener(backToMenuAction);
        scoresList.addActionListener(scoresListAction);
        playerDrawer = new EntityDrawer(new PlayerAnimation(gameState.getGame().getPlayerRepresentation().getPlayerEntity()));
        dragonDrawer = new EntityDrawer(new DragonAnimation(gameState.getGame().getDragon()));
        mapDrawer = new MapDrawer(() -> gameState.getGame().getMap());
        sightDrawer = new SightDrawer(gameState.getGame().getPlayerRepresentation().getPlayerEntity());
        repaint();
        add(gameOver);
        
    }

    @Override
    public void onCardNotShown() {
        backToMenu.removeActionListener(backToMenuAction);
        scoresList.removeActionListener(scoresListAction);
        removeAll();
        playerDrawer = null;
        dragonDrawer = null;
        mapDrawer = null;
        sightDrawer = null;
    }

    @Override
    public String getViewName() {
        return GameOver.class.getName();
    }
    
}
