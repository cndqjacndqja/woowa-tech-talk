package com.example.techtalk.dao;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.techtalk.entity.User;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void save() {
        // given

        // when
        User user = new User("name");
        Long savedId = userRepository.save(user).getId();

        // then
        assertThat(savedId).isNotNull();
    }

    @Test
    void findById() {
        // given
        User user = new User("name");
        Long savedId = userRepository.save(user).getId();

        //when
        User savedUser = userRepository.findById(savedId).orElseThrow();

        // then
        assertAll(
            () -> assertThat(savedUser.getId()).isEqualTo(savedId),
            () -> assertThat(savedUser.getName()).isEqualTo("name")
        );
    }
}
