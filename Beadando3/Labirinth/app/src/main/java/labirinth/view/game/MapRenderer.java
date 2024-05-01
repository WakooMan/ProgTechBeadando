package labirinth.view.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import labirinth.model.gamecontrol.Game;
import labirinth.model.gamecontrol.IGameListener;

/**
 * Renders the game map and entities on the screen.
 */
public class MapRenderer extends JComponent implements IGameListener {
    private int x;        
    private final Game game;
    private IDrawable playerDrawer;
    private IDrawable dragonDrawer;
    private IDrawable mapDrawer;
    private IDrawable sightDrawer;
    private final IDrawable timeDrawer;
    private int dms;
    
    /**
     * Constructs a MapRenderer object with the specified game.
     *
     * @param game The game instance.
     */
    public MapRenderer(Game game) {
        this.game = game;
        timeDrawer = new TimeDrawer();
        x = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        mapDrawer.draw(dms, g2);
        dragonDrawer.draw(dms, g2);
        playerDrawer.draw(dms, g2);
        sightDrawer.draw(dms, g2);
        timeDrawer.draw(dms, g2);
    }
    
    @Override
    public void onGameOver() { 
    }

    @Override
    public void onGameStarted() {
        playerDrawer = new EntityDrawer(new PlayerAnimation(game.getPlayerRepresentation().getPlayerEntity()));
        dragonDrawer = new EntityDrawer(new DragonAnimation(game.getDragon()));
        mapDrawer = new MapDrawer(() -> game.getMap());
        sightDrawer = new SightDrawer(game.getPlayerRepresentation().getPlayerEntity());
    }

    private void update() {
        this.x++;    
    }

    /**
     * Invoked on each game tick to update the rendering.
     *
     * @param dms The time passed since the last tick.
     */
    public void onTick(int dms) {
        this.dms = dms;
        update();
        repaint();   
    }
}
