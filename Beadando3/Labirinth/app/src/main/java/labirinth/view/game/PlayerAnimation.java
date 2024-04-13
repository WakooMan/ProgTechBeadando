/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.PlayerEntity;

/**
 *
 * @author vitya
 */
public class PlayerAnimation extends EntityAnimation {

    public PlayerAnimation(PlayerEntity entity) {
        super(entity, new HashMap<>()
        {{
            put(Direction.Up, AnimationLoader.loadAnimation(entity, "player/idle/up", 150));
            put(Direction.Right, AnimationLoader.loadAnimation(entity, "player/idle/right", 150));
            put(Direction.Left, AnimationLoader.loadAnimation(entity, "player/idle/left", 150));
            put(Direction.Down, AnimationLoader.loadAnimation(entity, "player/idle/down", 150));
        }}, new HashMap<>()
        {
          {
              put(Direction.Up, AnimationLoader.loadAnimation(entity, "player/move/up", 150));
              put(Direction.Right, AnimationLoader.loadAnimation(entity, "player/move/right", 150));
              put(Direction.Left, AnimationLoader.loadAnimation(entity, "player/move/left", 150));
              put(Direction.Down, AnimationLoader.loadAnimation(entity, "player/move/down", 150));
          }
        });
    }
}
