package com.uep.wap.tests;

import database.DatabaseConnection;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 1")) {
            if (resultSet.next()) {
                System.out.println("Połączenie z bazą danych: UDANE");
            } else {
                System.out.println("Połączenie z bazą danych: NIEUDANE");
            }
        } catch (Exception e) {
            System.out.println("Błąd połączenia z bazą danych: " + e.getMessage());
        }
    }
}
