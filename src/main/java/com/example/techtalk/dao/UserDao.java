package com.example.techtalk.dao;

import com.example.techtalk.entity.User;

public interface UserDao {

    Long save(User user);

    User findById(Long id);
}
