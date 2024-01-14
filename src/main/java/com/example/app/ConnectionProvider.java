package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection connection;

    //Method which provide the connection
    public static Connection getConnection() {
        //Creating Connection
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn", "root", "12345678");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
