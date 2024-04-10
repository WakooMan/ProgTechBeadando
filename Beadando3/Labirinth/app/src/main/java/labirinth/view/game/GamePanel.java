/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import javax.swing.JPanel;
import labirinth.model.map.Map;

/**
 *
 * @author vitya
 */
public class GamePanel extends JPanel {
    
    public GamePanel(Map map)
    {
        setSize(map.getSize(), map.getSize());
        add(new MapRenderer(map));
    }
    
}
