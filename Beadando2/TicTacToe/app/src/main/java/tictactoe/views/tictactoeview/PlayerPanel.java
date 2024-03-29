package tictactoe.views.tictactoeview;

import java.awt.Color;
import javax.swing.JButton;
import tictactoe.gamecontrol.Player;
import tictactoe.gamecontrol.PlayerListener;

public class PlayerPanel extends JButton {
           
   public PlayerPanel(Player player, boolean isCurrent)
   {
       super(player.getSignal() + " - " + player.getName());
       setEnabled(false);
       if(isCurrent)
       {
           onPlayerTurnAction();
       }
       else
       {
           afterPlayerSteppedAction();
       }
       player.addPlayerListener(new PlayerListener() {
        @Override
        public void onPlayerTurn()
        {
            onPlayerTurnAction();
        }
       
        @Override
        public void afterPlayerStepped()
        {
            afterPlayerSteppedAction();
        }
       });
   }
   
   private void onPlayerTurnAction()
   {
       setBackground(Color.green);
   }
   
   private void afterPlayerSteppedAction()
   {
       setBackground(Color.white);
   }
    
    
}
