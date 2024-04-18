/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model;

import labirinth.model.utilities.IKeyHandler;
import labirinth.model.utilities.IKeyHandlerFactory;
import labirinth.model.utilities.IRandomGenerator;
import labirinth.model.utilities.IRandomGeneratorFactory;
import labirinth.model.utilities.IScoreHandler;
import labirinth.model.utilities.IScoreHandlerFactory;
import labirinth.model.utilities.KeyHandlerFactory;
import labirinth.model.utilities.RandomGeneratorFactory;
import labirinth.model.utilities.ScoreHandlerFactory;

/**
 *
 * @author vitya
 */
public class ObjectCompositionUtils {
    private static IKeyHandler keyHandler;
    private static IRandomGenerator randomGenerator;
    private static IScoreHandler scoreHandler;
    
    public static IKeyHandler getDefaultKeyHandler()
    {
        if(keyHandler == null)
        {
            IKeyHandlerFactory factory = new KeyHandlerFactory();
            keyHandler = factory.create();
        }
        return keyHandler;
    }
    
    public static IRandomGenerator getDefaultRandomGenerator()
    {
        if(randomGenerator == null)
        {
            IRandomGeneratorFactory factory = new RandomGeneratorFactory();
            randomGenerator = factory.create();
        }
        return randomGenerator;
    }
    
    public static IScoreHandler getDefaultScoreHandler()
    {
        if(scoreHandler == null)
        {
            IScoreHandlerFactory factory = new ScoreHandlerFactory();
            scoreHandler = factory.create();
        }
        return scoreHandler;
    }
}
