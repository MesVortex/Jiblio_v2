package metier.Database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private DbConnection() {}

    private static Connection connection = null;

    public static Connection getInstance() {
        Dotenv dotenv = Dotenv.load();
        if (connection == null) {
            try {
                String url = dotenv.get("url");
                String user = dotenv.get("user");
                String password = dotenv.get("password");

                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                System.out.println("Error closing the database connection: " + e.getMessage());
            }
        }
    }
}
