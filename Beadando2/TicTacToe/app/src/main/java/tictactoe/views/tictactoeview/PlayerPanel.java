package tictactoe.views.tictactoeview;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import tictactoe.gamecontrol.Player;
import tictactoe.gamecontrol.PlayerListener;

public class PlayerPanel extends JPanel {
    private final JButton button;
           
   public PlayerPanel(Player player, boolean isCurrent)
   {
       button = new JButton(player.getSignal() + " - " + player.getName());
       button.setEnabled(false);
       if(isCurrent)
       {
           onPlayerTurnAction();
       }
       else
       {
           afterPlayerSteppedAction();
       }
       add(button);
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
       button.setBackground(Color.green);
   }
   
   private void afterPlayerSteppedAction()
   {
       button.setBackground(Color.white);
   }
    
    
}
