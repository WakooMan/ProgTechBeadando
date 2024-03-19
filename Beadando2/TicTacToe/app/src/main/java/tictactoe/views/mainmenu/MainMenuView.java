package tictactoe.views.mainmenu;

import javax.swing.BoxLayout;
import tictactoe.applicationstates.InMainMenu;
import tictactoe.gamemenu.IMenuOption;
import tictactoe.views.View;

public class MainMenuView extends View<InMainMenu>{
    public MainMenuView()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void initialize(InMainMenu state) {
        for(IMenuOption menuOption : state.getMainMenu().getOptions())
        {
            System.out.println("Add button:" + menuOption.getTitle());
            this.add(new MainMenuButton(menuOption));
        }
        //this.repaint();
        //this.revalidate();
    }

    @Override
    public void clear() {
        this.removeAll();
    }

    @Override
    public String getViewName() {
        return "MainMenuView";
    }
    
}