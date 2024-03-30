package tictactoe.views.tictactoeview;

import java.awt.Color;
import javax.swing.JButton;
import tictactoe.gamecontrol.Player;
import tictactoe.gamecontrol.PlayerListener;

/**
 * Represents a panel displaying information about a player.
 */
public class PlayerPanel extends JButton {
           
   /**
    * Constructs a new instance of the PlayerPanel class.
    * @param player The player to display information about.
    * @param isCurrent Indicates whether this player is currently active.
    */
   public PlayerPanel(Player player, boolean isCurrent) {
       super(player.getSignal() + " - " + player.getName()); // Set button text
       setEnabled(false); // Disable the button
       if(isCurrent) {
           onPlayerTurnAction(); // Highlight the panel if it's the player's turn
       } else {
           afterPlayerSteppedAction(); // Reset the panel appearance
       }
       // Add a player listener to update the panel appearance based on player events
       player.addPlayerListener(new PlayerListener() {
        @Override
        public void onPlayerTurn() {
            onPlayerTurnAction(); // Highlight the panel when it's the player's turn
        }
       
        @Override
        public void afterPlayerStepped() {
            afterPlayerSteppedAction(); // Reset the panel appearance after the player steps
        }
       });
   }
   
   /**
    * Sets the background color to green, indicating the player's turn.
    */
   private void onPlayerTurnAction() {
       setBackground(Color.green); // Set background color to green
   }
   
   /**
    * Sets the background color to white, indicating the player's turn has ended.
    */
   private void afterPlayerSteppedAction() {
       setBackground(Color.white); // Reset background color to white
   }
}
