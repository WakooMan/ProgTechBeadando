/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;
import labirinth.model.gamecontrol.Game;
import labirinth.model.map.MapConfiguration;

/**
 *
 * @author vitya
 */
public class MapRenderer extends JComponent implements ActionListener {
    private int x;        
    private final Game game;
    private final GameListener listener;
    private final int dms;
    
    public MapRenderer(Game game) {
        dms = 1000/60;
        Timer timer = new Timer(dms, this);
        this.game = game;
        listener = new GameListener(timer, game);
        this.game.addGameListener(listener);
        game.startGame();
        timer.start();
        x = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        listener.getMapDrawer().draw(dms, g2);
        listener.getDragonDrawer().draw(dms, g2);
        listener.getPlayerDrawer().draw(dms, g2);
        listener.getSightDrawer().draw(dms, g2);
        
    }

    private void update() {
        this.x++;    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.onTick();
        update();
        repaint();      
    }
}
