package com.example.techtalk.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techtalk.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);
}
