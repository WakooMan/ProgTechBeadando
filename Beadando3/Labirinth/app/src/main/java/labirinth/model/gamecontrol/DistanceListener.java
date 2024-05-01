/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.gamecontrol;

import labirinth.model.entities.PlayerEntity;
import labirinth.model.map.Block;
import labirinth.model.map.Map;

/**
 *
 * @author vitya
 */
public class DistanceListener {
    
    private final Game game;
    
    public DistanceListener(Game game)
    {
        this.game = game;
    }
    
    public void listen()
    {
        PlayerEntity player = game.getPlayerRepresentation().getPlayerEntity();
        Map map = game.getMap();
        Block playerBlock = map.getBlock(player.getPosition().getCenter());     
        Block dragonBlock = map.getBlock(game.getDragon().getPosition().getCenter());
        if(map.getNeighbors(playerBlock).contains(dragonBlock))
        {
            player.die();
        }
    }
    
}
