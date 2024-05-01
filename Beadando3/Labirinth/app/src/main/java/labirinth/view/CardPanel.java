package labirinth.view;

import javax.swing.JPanel;
import labirinth.model.gamestates.GameStateBase;

/**
 * Abstract class representing a panel that can be displayed as a card within a CardLayout.
 *
 * @param <T> The type of game state associated with this card panel.
 */
public abstract class CardPanel<T extends GameStateBase> extends JPanel {
    
    /**
     * Constructs a CardPanel.
     */
    protected CardPanel() {
        super();
    }
    
    /**
     * Called when this card panel is shown.
     *
     * @param gameState The current game state associated with this card panel.
     */
    public abstract void onCardShow(T gameState);
    
    /**
     * Called when this card panel is not shown.
     */
    public abstract void onCardNotShown();
    
    /**
     * Gets the name of this view.
     *
     * @return The name of this view.
     */
    public abstract String getViewName();
}
