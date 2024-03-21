package tictactoe.gamemenu.initializegamemenu;

import javax.swing.JOptionPane;
import tictactoe.ObjectComponentUtils;
import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.applicationstates.TicTacToe;
import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.MainWindow;

public class StartOption implements IMenuOption{
    private final InInitializeGameMenu gameMenu;
    private final IMatchFactory matchFactory;
    
    public StartOption(InInitializeGameMenu gameMenu) 
    {
        this.gameMenu = gameMenu;
        this.matchFactory = ObjectComponentUtils.getDefaultMatchFactory();
    }
    
    @Override
    public void doOption() {
        if(gameMenu.areInputsInvalid())
        {
            JOptionPane.showMessageDialog(MainWindow.getInstance(), "Cannot start the game, because some inputs are still invalid.");
        }
        else
        {
            ApplicationStateManager.getInstance().changeState(new TicTacToe(matchFactory.create(gameMenu.getMatchName(), gameMenu.getN(), gameMenu.getM(), gameMenu.getPlayer1(), gameMenu.getPlayer2())));
        }
    }

    @Override
    public String getTitle() {
        return "Start";
    }
}
