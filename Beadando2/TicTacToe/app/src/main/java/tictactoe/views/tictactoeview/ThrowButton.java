/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.views.tictactoeview;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author vitya
 */
public class ThrowButton extends JButton {
    public ThrowButton(ActionListener actionListener)
    {
        super();
        addActionListener(actionListener);
        setBackground(Color.cyan);
        setBorderPainted(false);
        setInvisible();
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setVisible();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setInvisible();
            }
        });
    }
    
    private void setVisible()
    {
        setContentAreaFilled(true);
    }
    
    private void setInvisible()
    {
        setContentAreaFilled(false);
    }
}
