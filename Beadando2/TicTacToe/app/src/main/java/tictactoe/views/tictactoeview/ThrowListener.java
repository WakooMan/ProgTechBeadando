/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.views.tictactoeview;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.applicationstates.TicTacToe;
/**
 *
 * @author vitya
 */
public class ThrowListener implements ActionListener {

    private final TicTacToe game;
    private final int column;
    public ThrowListener(TicTacToe game, int column)
    {
        this.game = game;
        this.column = column;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        game.throwWithCurrentPlayerAt(column);
    }
    
}
