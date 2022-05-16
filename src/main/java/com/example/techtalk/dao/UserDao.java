package com.example.techtalk.dao;

import com.example.techtalk.entity.User;
import java.sql.SQLException;

public interface UserDao {

    Long save(User user) throws SQLException;

    User findById(Long id);
}
