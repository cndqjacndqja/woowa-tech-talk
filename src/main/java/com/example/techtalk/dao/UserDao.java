package com.example.techtalk.dao;

import com.example.techtalk.entity.User;
import java.sql.SQLException;

public interface UserDao {

    Long save(User user) throws SQLException;

    User findOne(Long id);
}
