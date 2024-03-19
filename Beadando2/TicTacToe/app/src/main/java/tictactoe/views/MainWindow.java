package tictactoe.views;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tictactoe.ObjectComponentUtils;
import tictactoe.applicationstates.ApplicationStateManager;


public class MainWindow extends JFrame {
   
   private static MainWindow instance;
   private CardLayout cl;
   
   private MainWindow()
   {
       setTitle("TicTacToe");
       setSize(500,500);
       setLocationRelativeTo(null);
       setVisible(true);
       cl = new CardLayout();
       setLayout(cl);
       this.add(ObjectComponentUtils.getMainMenuView(), ObjectComponentUtils.getMainMenuView().getViewName());
       this.add(ObjectComponentUtils.getInitializeGameMenuView(), ObjectComponentUtils.getInitializeGameMenuView().getViewName());
       
   }
   
   public static MainWindow getInstance()
   {
       if(instance == null)
       {
           instance = new MainWindow();
       }
       return instance;
   }
   
   public void onViewChanged(View view)
   {
       System.out.println("OnViewChanged called.");
       cl.show(getContentPane(), view.getViewName());
   }
    
  public static void main(String[] args) {
      ApplicationStateManager.getInstance();
  }

}