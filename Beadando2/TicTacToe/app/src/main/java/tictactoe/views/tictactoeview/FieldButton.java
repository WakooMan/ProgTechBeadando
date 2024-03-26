/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.views.tictactoeview;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import tictactoe.table.Field;
import tictactoe.table.Signal;
/**
 *
 * @author vitya
 */
public class FieldButton extends JButton {
    
    private static HashMap<Signal, String> signalMap = new HashMap<>()
    {{
        put(Signal.Empty, "");
        put(Signal.X, "X");
        put(Signal.O, "O");
    }};
    
    
    public FieldButton(Field field)
    {
        setEnabled(false);
        setBackground(Color.white);
        setBorder(new LineBorder(Color.black));
        setFont(new Font("Arial", Font.PLAIN, 20));
        field.addListener((signal) -> setText(signalMap.get(signal)));
    }
    
}
