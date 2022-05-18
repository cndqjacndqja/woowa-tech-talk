package com.example.techtalk.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.techtalk.entity.User;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserDaoImplTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserDao userDao;

    @Test
    void save() throws SQLException {
        // given

        // when
        User user = new User("name");
        Long savedId = userDao.save(user);

        // then
        assertThat(savedId).isNotNull();
    }

    @Test
    void findById() throws SQLException {
        // given
        UserDao userDao = new UserDaoImpl(entityManager);
        User user = new User("name");
        Long savedId = userDao.save(user);

        //when
        User savedUser = userDao.findOne(savedId);

        // then
        assertAll(
            () -> assertThat(savedUser.getId()).isEqualTo(savedId),
            () -> assertThat(savedUser.getName()).isEqualTo("name")
        );
    }
}
