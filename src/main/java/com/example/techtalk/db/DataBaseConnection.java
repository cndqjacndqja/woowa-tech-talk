package com.example.techtalk.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String DATA_BASE_URL = "jdbc:h2:mem:testdb";

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(DATA_BASE_URL, "sa", "password");
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
