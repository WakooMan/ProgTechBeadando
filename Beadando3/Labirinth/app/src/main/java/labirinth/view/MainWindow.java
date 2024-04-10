package labirinth.view;

import javax.swing.JFrame;
import labirinth.model.gamecontrol.Game;
import labirinth.model.map.MapConfiguration;
import labirinth.model.utilities.KeyHandlerFactory;
import labirinth.view.game.MapRenderer;

public class MainWindow extends JFrame{
    public MainWindow()
    {
        super();
        int mapSize = 500;
        setTitle("Labirinth");
        setSize(mapSize + 100, mapSize + 100);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new KeyHandlerFactory().createListener());
        MapConfiguration.getInstance().setMapSize(mapSize);
        add(new MapRenderer(new Game()));
        setVisible(true);
    }
}
