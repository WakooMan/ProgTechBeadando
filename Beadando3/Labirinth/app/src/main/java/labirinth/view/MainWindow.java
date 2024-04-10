package labirinth.view;

import javax.swing.JFrame;
import labirinth.model.map.IMapGenerator;
import labirinth.model.map.IMapGeneratorFactory;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.MapGeneratorFactory;
import labirinth.view.game.GamePanel;
import labirinth.view.game.MapRenderer;

public class MainWindow extends JFrame{
    public MainWindow()
    {
        super();
        int mapSize = 500;
        setTitle("Labirinth");
        setSize(mapSize, mapSize);
        setLocationRelativeTo(null);
        setResizable(false);
        MapConfiguration.getInstance().setMapSize(mapSize);
        IMapGeneratorFactory factory = new MapGeneratorFactory();
        IMapGenerator gen = factory.create();
        add(new MapRenderer(gen.generateMap()));
        setVisible(true);
    }
}
