package labirinth.view;

import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JFrame;
import labirinth.model.ObjectCompositionUtils;
import labirinth.model.gamestates.GameStateBase;
import labirinth.model.gamestates.GameStateMachine;
import labirinth.model.gamestates.MainMenu;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.view.game.GamePanel;
import labirinth.view.mainmenu.MainMenuPanel;
import labirinth.view.startgamemenu.StartGameMenuPanel;

public class MainWindow extends JFrame{
    private final CardLayout cl;
    private final HashMap<String, CardPanel> cardPanels;
    private final GameStateMachine stateMachine;
    private CardPanel currentPanel;
    
    public MainWindow()
    {
        super();
        this.stateMachine = new GameStateMachine();
        cardPanels = new HashMap<>();
        currentPanel = null;
        int mapSize = 800;
        setTitle("Labirinth");
        setSize(mapSize, mapSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(true);
        cl = new CardLayout();
        setLayout(cl);
        addKeyListener(ObjectCompositionUtils.getDefaultKeyHandler());
        MapConfiguration.getInstance().setMapSize(new Position(mapSize, mapSize));
        addCardPanel(new MainMenuPanel());
        addCardPanel(new StartGameMenuPanel());
        addCardPanel(new GamePanel());
        this.stateMachine.addGameStateListener((gameState) -> 
        {
            changeCardAction(gameState);
        });
        stateMachine.changeState(new MainMenu(stateMachine));
        setVisible(true);
    }
    
    private void addCardPanel(CardPanel panel)
    {
        cardPanels.put(panel.getViewName(), panel);
        add(panel, panel.getViewName());
    }
    
    private void changeCardAction(GameStateBase gameState)
    {
        if(currentPanel != null)
        {
            currentPanel.onCardNotShown();
        }
        currentPanel = cardPanels.get(gameState.getClass().getName());
        currentPanel.onCardShow(gameState);
        cl.show(getContentPane(), gameState.getClass().getName());
        this.requestFocusInWindow();
    }
}
