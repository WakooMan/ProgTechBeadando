package labirinth.model.gamecontrol;

import labirinth.model.entities.IPlayerEntityListener;

public class PlayerEntityListener implements IPlayerEntityListener{

    private final Runnable onPlayerDies, onPlayerWins;
    
    public PlayerEntityListener(Runnable onPlayerDies, Runnable onPlayerWins)
    {
        this.onPlayerDies = onPlayerDies;
        this.onPlayerWins = onPlayerWins;
    }
    
    @Override
    public void onPlayerDies() {
        this.onPlayerDies.run();
    }

    @Override
    public void onPlayerWins() {
        this.onPlayerWins.run();
    }
    
}
