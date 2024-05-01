package labirinth.view.mainmenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import labirinth.model.gamestates.MainMenu;
import labirinth.view.CardPanel;

/**
 * Panel for displaying the main menu.
 * This panel provides buttons for starting the game, accessing the scores, and exiting the game.
 */
public class MainMenuPanel extends CardPanel<MainMenu> {

    private final JButton startGame;
    private final JButton scoreList;
    private final JButton exitGame;
    private ActionListener startGameAction;
    private ActionListener scoreListAction;
    private ActionListener exitGameAction;
    
    /**
     * Constructs a new MainMenuPanel.
     * Initializes the components and sets up the layout.
     */
    public MainMenuPanel() {
        super();
        setBackground(Color.BLACK);
        startGame = new JButton("START GAME");
        scoreList = new JButton("SCORES");
        exitGame = new JButton("EXIT GAME");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.5;
        modifyButton(startGame, c);
        c.gridy = 1;
        modifyButton(scoreList, c);
        c.gridy = 2;
        modifyButton(exitGame, c);
    }
    
    /**
     * Callback method invoked when the main menu card is shown.
     * Assigns actions to the buttons for starting the game, accessing the scores, and exiting the game.
     * 
     * @param gameState The MainMenu state providing necessary information.
     */
    @Override
    public void onCardShow(MainMenu gameState) {
        startGameAction = (e)-> {
           gameState.startGame();
        };
        scoreListAction =(e) -> {
            gameState.scoresList();
        };
        exitGameAction = (e) -> {
            gameState.exitGame();
        };
        
        startGame.addActionListener(startGameAction);
        scoreList.addActionListener(scoreListAction);
        exitGame.addActionListener(exitGameAction);
    }

    /**
     * Callback method invoked when the main menu card is not shown.
     * Removes action listeners from the buttons.
     */
    @Override
    public void onCardNotShown() {
        startGame.removeActionListener(startGameAction);
        scoreList.removeActionListener(scoreListAction);
        exitGame.removeActionListener(exitGameAction);
    }

    /**
     * Gets the name of the view.
     * 
     * @return The name of the view.
     */
    @Override
    public String getViewName() {
        return MainMenu.class.getName();
    }
    
    /**
     * Modifies the appearance of a button.
     * 
     * @param button The button to modify.
     * @param c The constraints to apply.
     */
    private void modifyButton(JButton button, GridBagConstraints c) {
        button.setPreferredSize(new Dimension(800, 200)); // Set button size
        button.setBackground(Color.gray); // Set button background color
        button.setFont(new Font("Arial", Font.PLAIN, 50)); // Set button font
        add(button, c); // Add button to the view
    }
}
