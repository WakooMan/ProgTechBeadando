package labirinth.view.gameover;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import labirinth.model.gamestates.GameOver;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.view.CardPanel;
import labirinth.view.game.DragonAnimation;
import labirinth.view.game.EntityDrawer;
import labirinth.view.game.IDrawable;
import labirinth.view.game.MapDrawer;
import labirinth.view.game.PlayerAnimation;

/**
 * Panel for displaying the game over screen.
 */
public class GameOverPanel extends CardPanel<GameOver> {

    private GameOverMessage gameOverMessage;
    private IDrawable playerDrawer;
    private IDrawable dragonDrawer;
    private IDrawable mapDrawer;

    /**
     * Constructs a new GameOverPanel.
     */
    public GameOverPanel() {
        super();
        setLayout(new GridBagLayout());
        setBackground(Color.black);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Component c = (Component) evt.getSource();
                MapConfiguration.getInstance().setMapSize(new Position((int)(c.getWidth() * 0.99), c.getHeight()));
                if (gameOverMessage != null) {
                    gameOverMessage.setSize(new Dimension(c.getWidth() / 100 * 40, c.getHeight() / 100 * 20));
                }
            }
        });
    }

    /**
     * Paints the components of the panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (mapDrawer != null) {
            mapDrawer.draw(0, g2);
        }
        if (dragonDrawer != null) {
            dragonDrawer.draw(0, g2);
        }
        if (playerDrawer != null) {
            playerDrawer.draw(0, g2);
        }
    }

    /**
     * Callback method invoked when the game over card is shown.
     * 
     * @param gameState The game over state providing necessary information.
     */
    @Override
    public void onCardShow(GameOver gameState) {
        gameOverMessage = new GameOverMessage(gameState);
        playerDrawer = new EntityDrawer(new PlayerAnimation(gameState.getGame().getPlayerRepresentation().getPlayerEntity()));
        dragonDrawer = new EntityDrawer(new DragonAnimation(gameState.getGame().getDragon()));
        mapDrawer = new MapDrawer(() -> gameState.getGame().getMap());
        repaint();
        GridBagConstraints gbc = new GridBagConstraints();
        add(gameOverMessage, gbc);
        gameOverMessage.setSize(new Dimension(getWidth() / 100 * 40, getHeight() / 100 * 20));
    }

    /**
     * Callback method invoked when the game over card is not shown.
     */
    @Override
    public void onCardNotShown() {
        removeAll();
        playerDrawer = null;
        dragonDrawer = null;
        mapDrawer = null;
        gameOverMessage = null;
    }

    /**
     * Gets the name of the view.
     * 
     * @return The name of the view.
     */
    @Override
    public String getViewName() {
        return GameOver.class.getName();
    }
}
