/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;
import labirinth.model.entities.Direction;
import labirinth.model.map.Block;
import labirinth.model.map.Map;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;

/**
 *
 * @author vitya
 */
public class MapRenderer extends JComponent implements ActionListener {
    private int x;        
    private final Map map;
    public MapRenderer(Map map) {
        this.map = map;
        //Timer timer = new Timer(1000/60, this);
        //timer.start();
        x = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        for(int i = 0;i < map.getBlockNum(); i++)
        {
            for(int j = 0;j < map.getBlockNum(); j++)
            {
                Block block = map.getBlock(i, j);
                g2.setStroke(new BasicStroke(1));
                g2.setColor(Color.GREEN);
                g2.fillRect(block.getUpperLeftPoint().getX(), block.getUpperLeftPoint().getY(), block.getSize(), block.getSize());
                if(block.getCell().getWall(Direction.Up) != null)
                {
                    drawLine(g2, block.getUpperLeftPoint(), block.getUpperRightPoint());   
                }
                if(block.getCell().getWall(Direction.Right) != null)
                {
                    drawLine(g2, block.getUpperRightPoint(), block.getBottomRightPoint());   
                }
                if(block.getCell().getWall(Direction.Left) != null)
                {
                    drawLine(g2, block.getUpperLeftPoint(), block.getBottomLeftPoint());   
                }
                if(block.getCell().getWall(Direction.Down) != null)
                {
                    drawLine(g2, block.getBottomLeftPoint(), block.getBottomRightPoint());   
                }
            }
        }
    }
    
    private void drawLine(Graphics2D g, Position from, Position to)
    {
        g.setStroke(new BasicStroke(MapConfiguration.getInstance().getWallSize()));
        g.setColor(Color.ORANGE);
        g.drawLine(from.getX(), from.getY(), to.getX(), to.getY()); 
    }

    private void update() {
        this.x++;    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();      
    }
}
