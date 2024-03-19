package tictactoe.gamemenu.initializegamemenu;

import tictactoe.ObjectComponentUtils;
import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InInitializeGameMenu;
import tictactoe.applicationstates.TicTacToe;
import tictactoe.gamecontrol.IMatchFactory;
import tictactoe.gamemenu.IMenuOption;

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
        ApplicationStateManager.getInstance().changeState(new TicTacToe(matchFactory.create(gameMenu.getMatchName(), gameMenu.getN(), gameMenu.getM(), gameMenu.getPlayer1(), gameMenu.getPlayer2())));
    }

    @Override
    public String getTitle() {
        return "Start";
    }
}
