package cl.clasejava.bd_museos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    // it certainly took me a while, just to remember that I had to make it a
    // singleton, I mean, having just a singular instance of a class, to allow
    // myself into using it on the rest of the code, thank goodness I was
    // looking onto my documents directory, took me some days just to find it
    private String address;
    private String port;
    private String database;
    private String user;
    private String password;
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Constructor privado para evitar instanciación directa
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void setConnection(String address,
            String port,
            String database,
            String user,
            String password) throws SQLException {
        this.address = address;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        connection = DriverManager.getConnection(
                "jdbc:mysql://"
                + address + ":" + port
                + "/" + database,
                user,
                password);
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + address + ":" + port
                    + "/" + database,
                    user,
                    password);
        }
        return connection;
    }

    public boolean isConnected() throws SQLException {
        return connection != null && !connection.isClosed();
    }

    public boolean testConnection(String address,
            String port,
            String database,
            String user,
            String password) {
        String url = "jdbc:mysql://" + address + ":" + port + "/" + database;
        try {
            // Try connecting
            connection = DriverManager.getConnection(url, user, password);

            // Verify db existance
            return checkDatabaseExists(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error setting connection
        } finally {
            // Close it if connected
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean checkDatabaseExists(Connection connection) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SHOW TABLES");
            return resultSet.next(); // return true if there's at least one table
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}
