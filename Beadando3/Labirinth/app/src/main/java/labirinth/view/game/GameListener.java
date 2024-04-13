/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import javax.swing.Timer;
import labirinth.model.gamecontrol.Game;
import labirinth.model.gamecontrol.IGameListener;

/**
 *
 * @author vitya
 */
public class GameListener implements IGameListener {

    private final Timer timer;
    private final Game game;
    private IDrawable playerDrawer;
    private IDrawable dragonDrawer;
    private IDrawable mapDrawer;
    private IDrawable sightDrawer;
    
    public GameListener(Timer timer, Game game)
    {
        this.game = game;
        this.timer = timer;
    }
    
    @Override
    public void onGameOver() {
        timer.stop();
    }

    @Override
    public void onGameStarted() {
        playerDrawer = new EntityDrawer(new PlayerAnimation(game.getPlayerRepresentation().getPlayerEntity()));
        dragonDrawer = new EntityDrawer(new DragonAnimation(game.getDragon()));
        mapDrawer = new MapDrawer(() -> game.getMap());
        sightDrawer = new SightDrawer(game.getPlayerRepresentation().getPlayerEntity());
    }
    
    public IDrawable getPlayerDrawer()
    {
        return playerDrawer;
    }
    
    public IDrawable getDragonDrawer()
    {
        return dragonDrawer;
    }
    
    public IDrawable getMapDrawer()
    {
        return mapDrawer;
    }
    public IDrawable getSightDrawer()
    {
        return sightDrawer;
    }
    
}
