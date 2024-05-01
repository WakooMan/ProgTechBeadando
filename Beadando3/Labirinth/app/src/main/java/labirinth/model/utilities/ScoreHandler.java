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
 * Handles scores stored in a MySQL database.
 * Implements the IScoreHandler interface.
 */
public class ScoreHandler implements IScoreHandler {

    private MysqlConnectionPoolDataSource conn;
    
    /**
     * Retrieves a database connection.
     *
     * @return A Connection object representing the database connection.
     */
    private Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = new MysqlConnectionPoolDataSource();
                conn.setServerName("localhost");
                conn.setPort(3306);
                conn.setDatabaseName("labirinth");
                conn.setUser("tanulo");
                conn.setPassword("asdasd123*");
            }
            return conn.getPooledConnection().getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            conn = null;
            return null;
        }
    }
    
    @Override
    public List<ScoreDto> getScores() throws SQLException {
        Connection connection = getConnection();
        List<ScoreDto> result = new ArrayList<>();
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            String query = "SELECT * FROM scores ORDER BY MapCount DESC";
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                result.add(new ScoreDto(res.getString(2), res.getInt(3)));
            }
        }
        return result;
    }

    @Override
    public void addScore(String playerName, int score) throws SQLException {
        Connection connection = getConnection();
        if (shouldInsertPlayer(connection, playerName, score)) {
            System.out.println("valami");
            String insertion = "INSERT INTO scores VALUES(NULL,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(insertion)) {
                statement.setString(1, playerName);
                statement.setInt(2, score);
                statement.addBatch();
                System.out.println("valami2");
                statement.executeBatch();
            }
        }
    }
    
    /**
     * Checks if the player's score should be inserted into the database.
     *
     * @param connection The database connection.
     * @param playerName The name of the player.
     * @param score The score of the player.
     * @return True if the player's score should be inserted, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
    private boolean shouldInsertPlayer(Connection connection, String playerName, int score) throws SQLException {
        String query = "SELECT * FROM scores WHERE Name=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, playerName);
            statement.addBatch();
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                if (res.getInt(2) >= score) {
                    System.out.println("false");
                    return false;
                }
                String deletion = "DELETE FROM scores WHERE Name=?";
                try (PreparedStatement statement2 = connection.prepareStatement(deletion)) {
                    statement2.setString(1, playerName);
                    statement2.addBatch();
                    statement2.executeBatch();
                }
                System.out.println("true");
                return true;
            }
        }
        System.out.println("true");
        return true;
    }
}
