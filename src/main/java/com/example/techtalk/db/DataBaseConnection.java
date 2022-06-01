package com.example.techtalk.db;

import java.sql.Connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataBaseConnection {
    private static final String DATA_BASE_URL = "jdbc:h2:mem:testdb";

    public static Connection getConnection() {
        try {
            return new DriverManagerDataSource(DATA_BASE_URL, "sa", "password").getConnection();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
