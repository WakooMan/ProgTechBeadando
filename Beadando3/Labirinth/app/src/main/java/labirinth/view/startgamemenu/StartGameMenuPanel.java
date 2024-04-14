/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.startgamemenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.function.Consumer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import labirinth.view.CardPanel;

/**
 *
 * @author vitya
 */
public class StartGameMenuPanel extends CardPanel {

    private final JButton start;
    private final JButton back;
    private final JTextField nameField;
    
    public StartGameMenuPanel(Consumer<String> changeCard)
    {
        super(changeCard);
        start = new JButton("START");
        start.addActionListener((e) -> 
        {
            changeCard("Game");
        });
        back = new JButton("BACK");
        back.addActionListener((e) -> 
        {
            changeCard("MainMenu");
        });
        nameField = new JTextField(20);
        modifyButton(start);
        modifyButton(back);
        modifyTextField(nameField);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(nameField, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(back, gbc);
        gbc.gridx = 1;
        panel.add(start, gbc);
        add(panel);
        
    }
    
    @Override
    public void onCardShow() {
        
    }

    @Override
    public void onCardNotShown() {
        
    }

    @Override
    public String getViewName() {
        return "StartGameMenu";
    }
    
    private void modifyButton(JButton button)
    {
        button.setPreferredSize(new Dimension(200, 50)); // Set button size
        button.setBackground(Color.gray); // Set button background color
        button.setFont(new Font("Arial", Font.PLAIN, 20)); // Set button font
    }
    
    private void modifyTextField(JTextField textField)
    {
        textField.setPreferredSize(new Dimension(300, 100)); // Set button size
        textField.setBackground(Color.gray); // Set button background color
        textField.setFont(new Font("Arial", Font.PLAIN, 40)); // Set button font
        textField.setForeground(Color.BLACK);
    }
    
}
