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
import java.util.function.Consumer;
import javax.swing.JButton;
import labirinth.view.CardPanel;

/**
 *
 * @author vitya
 */
public class MainMenuPanel extends CardPanel {

    private final JButton startGame;
    private final JButton scoreList;
    private final JButton exitGame;
    
    public MainMenuPanel(Consumer<String> changeCard)
    {
        super(changeCard);
        setBackground(Color.BLACK);
        startGame = new JButton("START GAME");
        startGame.addActionListener((e)-> 
        {
           changeCard("StartGameMenu");
        });
        scoreList = new JButton("SCORES");
        scoreList.addActionListener((e) -> 
        {
            changeCard("StartGameMenu");
        });
        exitGame = new JButton("EXIT GAME");
        exitGame.addActionListener((e) -> 
        {
            System.exit(0);
        });
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
    public void onCardShow() {
        
    }

    @Override
    public void onCardNotShown() {
    }

    @Override
    public String getViewName() {
        return "MainMenu";
    }
    
    private void modifyButton(JButton button, GridBagConstraints c)
    {
        button.setPreferredSize(new Dimension(800, 200)); // Set button size
        button.setBackground(Color.gray); // Set button background color
        button.setFont(new Font("Arial", Font.PLAIN, 50)); // Set button font
        add(button, c); // Add button to the view
    }
    
}
