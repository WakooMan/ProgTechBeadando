package tictactoe.views;

import java.awt.CardLayout;
import javax.swing.JFrame;
import tictactoe.ObjectCompositionUtils;
import tictactoe.applicationstates.ApplicationStateManager;

/**
 * Represents the main window of the Tic Tac Toe game.
 */
public class MainWindow extends JFrame {
   
   private static MainWindow instance;
   private final CardLayout cl;
   
   /**
    * Constructs a new instance of the MainWindow class.
    * Private constructor to enforce singleton pattern.
    */
   private MainWindow() {
       setTitle("TicTacToe");
       setSize(1280,1024);
       setLocationRelativeTo(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       setResizable(false);
       cl = new CardLayout();
       setLayout(cl);
       // Add main menu, initialize game menu, and Tic Tac Toe game views
       this.add(ObjectCompositionUtils.getMainMenuView(), ObjectCompositionUtils.getMainMenuView().getViewName());
       this.add(ObjectCompositionUtils.getInitializeGameMenuView(), ObjectCompositionUtils.getInitializeGameMenuView().getViewName());
       this.add(ObjectCompositionUtils.getTicTacToeGameView(), ObjectCompositionUtils.getTicTacToeGameView().getViewName());
   }
   
   /**
    * Retrieves the singleton instance of the MainWindow class.
    * @return The singleton instance of the MainWindow.
    */
   public static MainWindow getInstance() {
       if(instance == null) {
           instance = new MainWindow();
       }
       return instance;
   }
   
   /**
    * Handles the change of view in the main window.
    * @param view The new view to be displayed.
    */
   public void onViewChanged(View view) {
       System.out.println("OnViewChanged called.");
       cl.show(getContentPane(), view.getViewName());
   }
    
   /**
    * Main method to start the application.
    * @param args Command-line arguments (not used).
    */
  public static void main(String[] args) {
      ApplicationStateManager.getInstance();
  }

}
