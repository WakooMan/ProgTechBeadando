/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.utilities;

/**
 *
 * @author vitya
 */
public class ScoreHandlerFactory implements IScoreHandlerFactory {

    @Override
    public IScoreHandler create() {
        return new ScoreHandler();
    }
    
}
