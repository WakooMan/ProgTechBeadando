/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe.gamecontrol;

/**
 *
 * @author vitya
 */
public interface MatchListener {
    void onGameOver(Player player);
    void onColumnFilled(int column);
    void onColumnCleared(int column);
}
