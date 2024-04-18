/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import labirinth.model.gamestates.PlayingGame;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.view.CardPanel;

/**
 *
 * @author vitya
 */
public class GamePanel extends CardPanel<PlayingGame> {
    
    private GameController controller;
    
    public GamePanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.black);
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
    public void onCardShow(PlayingGame gameState) {
        controller = new GameController(gameState);
        add(controller.getMapRenderer());
        controller.startGame();
    }

    @Override
    public void onCardNotShown() {
        removeAll();
        controller = null;
    }

    @Override
    public String getViewName() {
        return PlayingGame.class.getName();
    }
    
}
