package tictactoe.views;

import javax.swing.JFrame;


public class MainWindow extends JFrame {
    
   private MainWindow()
   {
       setTitle("TicTacToe");
       setSize(500,500);
       setLocationRelativeTo(null);
       setVisible(true);
       this.add(new MainMenuView());
       show();
       
   }
    
  public static void main(String[] args) {
      new MainWindow();
  }

}