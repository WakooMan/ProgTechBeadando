package labirinth.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import labirinth.model.gamecontrol.Game;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.model.utilities.KeyHandlerFactory;
import labirinth.view.game.MapRenderer;

public class MainWindow extends JFrame{
    public MainWindow()
    {
        super();
        int mapSize = 500;
        setTitle("Labirinth");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.black);
        panel.addComponentListener(new ComponentAdapter() 
        {
            @Override
            public void componentResized(ComponentEvent evt) {
            Component c = (Component)evt.getSource();
            MapConfiguration.getInstance().setMapSize(new Position((int)(c.getWidth() * 0.99), c.getHeight()));
            }
        });
        setSize(mapSize, mapSize);
        setLocationRelativeTo(null);
        setResizable(true);
        addKeyListener(new KeyHandlerFactory().createListener());
        MapConfiguration.getInstance().setMapSize(new Position(mapSize, mapSize));
        panel.add(new MapRenderer(new Game()));
        add(panel);
        setVisible(true);
    }
}
