package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/yourney_database"; // zmień URL
    private static final String USER = "root"; // zmień na twojego użytkownika
    private static final String PASSWORD = "OS84995"; // zmień na twoje hasło

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
