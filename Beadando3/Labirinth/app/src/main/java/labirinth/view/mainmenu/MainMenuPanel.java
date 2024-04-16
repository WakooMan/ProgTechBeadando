/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author vitya
 */
public class MainMenuPanel extends CardPanel<MainMenu> {

    private final JButton startGame;
    private final JButton scoreList;
    private final JButton exitGame;
    private ActionListener startGameAction;
    private ActionListener scoreListAction;
    private ActionListener exitGameAction;
    
    public MainMenuPanel()
    {
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
    
    @Override
    public void onCardShow(MainMenu gameState) {
        startGameAction = (e)-> 
        {
           gameState.startGame();
        };
        scoreListAction =(e) -> 
        {
            //
        };
        exitGameAction = (e) -> 
        {
            gameState.exitGame();
        };
        
        startGame.addActionListener(startGameAction);
        scoreList.addActionListener(scoreListAction);
        exitGame.addActionListener(exitGameAction);
    }

    @Override
    public void onCardNotShown() {
        startGame.removeActionListener(startGameAction);
        scoreList.removeActionListener(scoreListAction);
        exitGame.removeActionListener(exitGameAction);
    }

    @Override
    public String getViewName() {
        return MainMenu.class.getName();
    }
    
    private void modifyButton(JButton button, GridBagConstraints c)
    {
        button.setPreferredSize(new Dimension(800, 200)); // Set button size
        button.setBackground(Color.gray); // Set button background color
        button.setFont(new Font("Arial", Font.PLAIN, 50)); // Set button font
        add(button, c); // Add button to the view
    }
}
