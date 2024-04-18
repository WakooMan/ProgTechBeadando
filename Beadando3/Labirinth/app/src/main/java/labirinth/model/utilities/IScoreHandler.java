/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.utilities;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vitya
 */
public interface IScoreHandler {
    List<ScoreDto> getScores() throws SQLException;
    void addScore(String playerName, int score) throws SQLException;
}
