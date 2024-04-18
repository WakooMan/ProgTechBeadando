/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinth.model.utilities;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitya
 */
public class ScoreHandler implements IScoreHandler {

    private MysqlConnectionPoolDataSource conn;
    
    private Connection getConnection()
    {
        try{
            
            if(conn == null)
            {
                Class.forName("com.mysql.jbdc.Driver");
                conn = new MysqlConnectionPoolDataSource();
                conn.setServerName("localhost");
                conn.setPort(3306);
                conn.setDatabaseName("labirinth");
                conn.setUser("tanulo");
                conn.setPassword("asd123");
            }
            return conn.getPooledConnection().getConnection();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            conn = null;
            return null;
        }
    }
    
    @Override
    public List<ScoreDto> getScores() throws SQLException{
        Connection connection = getConnection();
        List<ScoreDto> result = new ArrayList<>();
        try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE))
        {
            String query = "SELECT * FROM scores";
            ResultSet res = statement.executeQuery(query);
            while(res.next())
            {
                result.add(new ScoreDto(res.getString(1), res.getInt(2)));
            }
        }
        
        return result;
    }

    @Override
    public void addScore(String playerName, int score) throws SQLException {
        Connection connection = getConnection();
        if(shouldInsertPlayer(connection, playerName, score))
        {
            String insertion = "INSERT INTO scores VALUES(?,?)";
            try(PreparedStatement statement = connection.prepareStatement(insertion))
            {
                statement.setString(1, playerName);
                statement.setInt(2, score);
                statement.addBatch();
                statement.executeBatch();
            }
        }
    }
    
    private boolean shouldInsertPlayer(Connection connection, String playerName, int score) throws SQLException
    {
        String query = "SELECT * FROM scores WHERE Name=?";
        try(PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, playerName);
            statement.addBatch();
            ResultSet res = statement.executeQuery();
            if(res.next())
            {
                if(res.getInt(2) >= score)
                {
                    return false;
                }
                String deletion = "DELETE FROM scores WHERE Name=?";
                try(PreparedStatement statement2 = connection.prepareStatement(deletion))
                {
                    statement2.setString(1, playerName);
                    statement2.addBatch();
                    statement2.executeBatch();
                }
                return true;
            }
        }
        
        return true;
    }
    
}
