package com.example.techtalk.db;


import java.sql.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataBaseConnectionTest {

    @Test
    void getConnection() {
        try{
            Connection connection = DataBaseConnection.getConnection();
            System.out.println(connection);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
