package com.Netinsight.Netinsight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://10.0.2.15:5432/mydb";
        String username = "dbhever";
        String password = "Sample";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
