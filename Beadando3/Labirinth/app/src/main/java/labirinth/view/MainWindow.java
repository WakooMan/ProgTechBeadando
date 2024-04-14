package labirinth.view;

import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JFrame;
import labirinth.model.map.MapConfiguration;
import labirinth.model.map.Position;
import labirinth.model.utilities.KeyHandlerFactory;
import labirinth.view.game.GamePanel;
import labirinth.view.mainmenu.MainMenuPanel;
import labirinth.view.startgamemenu.StartGameMenuPanel;

public class MainWindow extends JFrame{
    private final CardLayout cl;
    private final HashMap<String, CardPanel> cardPanels;
    private CardPanel currentPanel;
    
    public MainWindow()
    {
        super();
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
        addKeyListener(new KeyHandlerFactory().createListener());
        MapConfiguration.getInstance().setMapSize(new Position(mapSize, mapSize));
        MainMenuPanel starterPanel = new MainMenuPanel((cardName) -> { changeCardAction(cardName); });
        addCardPanel(starterPanel);
        addCardPanel(new StartGameMenuPanel((cardName) -> { changeCardAction(cardName); }));
        addCardPanel(new GamePanel((cardName) -> { changeCardAction(cardName); }));
        setVisible(true);
        changeCardAction(starterPanel.getViewName());
    }
    
    private void addCardPanel(CardPanel panel)
    {
        cardPanels.put(panel.getViewName(), panel);
        add(panel, panel.getViewName());
    }
    
    private void changeCardAction(String cardName)
    {
        if(currentPanel != null)
        {
            currentPanel.onCardNotShown();
        }
        currentPanel = cardPanels.get(cardName);
        currentPanel.onCardShow();
        cl.show(getContentPane(), cardName);
        this.requestFocusInWindow();
    }
}
