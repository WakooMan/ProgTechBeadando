/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.views.tictactoeview;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

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
        this.setBorder(new LineBorder(Color.GREEN, 5));
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
    
    public void onColumnFilled()
    {
        setEnabled(false);
        setBorder(new LineBorder(Color.RED, 5));
        setInvisible();
    }
    
    public void onColumnCleared()
    {
        setEnabled(true);
        setBorder(new LineBorder(Color.GREEN, 5));
    }
    
    private void setVisible()
    {
        if(this.isEnabled())
        {
            setContentAreaFilled(true);
        }
    }
    
    private void setInvisible()
    {
        setContentAreaFilled(false);
    }
}
