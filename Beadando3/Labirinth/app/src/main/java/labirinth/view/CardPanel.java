/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view;

import java.awt.CardLayout;
import java.util.function.Consumer;
import javax.swing.JPanel;

/**
 *
 * @author vitya
 */
public abstract class CardPanel extends JPanel {
    
    private final Consumer<String> changeCard;
    
    protected CardPanel(Consumer<String> changeCard)
    {
        super();
        this.changeCard = changeCard;
    }
    
    protected void changeCard(String cardName)
    {
        changeCard.accept(cardName);
    }
    
    public abstract void onCardShow();
    public abstract void onCardNotShown();
    public abstract String getViewName();
    
}
