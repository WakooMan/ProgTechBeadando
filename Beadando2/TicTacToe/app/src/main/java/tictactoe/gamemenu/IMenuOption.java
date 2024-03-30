package tictactoe.gamemenu;

/**
 * Abstract interface for menu option.
 */
public interface IMenuOption {

    /**
    * Does the menu option's action.
    */
    public void doOption();
  
    /**
    * Gets the title of the menu option.
    * @return Title.
    */
    public String getTitle();

}