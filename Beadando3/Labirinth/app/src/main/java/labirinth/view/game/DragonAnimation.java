/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.view.game;

import java.util.HashMap;
import labirinth.model.entities.Direction;
import labirinth.model.entities.Dragon;

/**
 *
 * @author vitya
 */
public class DragonAnimation extends EntityAnimation {
    
    public DragonAnimation(Dragon entity) {
        super(entity, new HashMap<>()
        {{
            put(Direction.Up, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
            put(Direction.Right, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
            put(Direction.Left, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
            put(Direction.Down, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
        }}, new HashMap<>()
        {
          {
              put(Direction.Up, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
              put(Direction.Right, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
              put(Direction.Left, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
              put(Direction.Down, AnimationLoader.loadAnimation(entity, "dragon/dragon", 250));
          }
        });
    }
    
}
