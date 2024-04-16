/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view;

import javax.swing.JPanel;
import labirinth.model.gamestates.GameStateBase;

/**
 *
 * @author vitya
 * @param <T>
 */
public abstract class CardPanel<T extends GameStateBase> extends JPanel {
    
    protected CardPanel()
    {
        super();
    }
    
    public abstract void onCardShow(T gameState);
    public abstract void onCardNotShown();
    public abstract String getViewName();
    
}
