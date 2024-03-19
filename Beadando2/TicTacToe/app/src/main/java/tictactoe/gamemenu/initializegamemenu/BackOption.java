package tictactoe.gamemenu.initializegamemenu;

import tictactoe.applicationstates.ApplicationStateManager;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;

public class BackOption implements IMenuOption{

    public BackOption() 
    {
    }
    
    @Override
    public void doOption() {
        ApplicationStateManager.getInstance().changeState(new InMainMenu());
    }

    @Override
    public String getTitle() {
        return "Back";
    }
    
}
