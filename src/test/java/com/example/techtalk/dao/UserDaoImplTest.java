package com.example.techtalk.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.techtalk.entity.User;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
class UserDaoImplTest {

    @Test
    void save() throws SQLException {
        // given
        UserDao userDao = new UserDaoImpl();

        // when
        User user = new User("name");
        Long savedId = userDao.save(user);

        // then
        assertThat(savedId).isNotNull();
    }

    @Test
    void findById() throws SQLException {
        // given
        UserDao userDao = new UserDaoImpl();
        User user = new User("name");
        Long savedId = userDao.save(user);

        //when
        User savedUser = userDao.findById(savedId);

        // then
        assertAll(
            () -> assertThat(savedUser.getId()).isEqualTo(savedId),
            () -> assertThat(savedUser.getName()).isEqualTo("name")
        );
    }
}
