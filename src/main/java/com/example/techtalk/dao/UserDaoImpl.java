package com.example.techtalk.dao;

import com.example.techtalk.entity.User;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long save(User user) {
        final String sql = "insert into user (name) values (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, user.getName());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public User findById(Long id) {
        final String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, userMapper(), id);
    }

    private RowMapper<User> userMapper() {
        return (resultSet, rowNum) -> new User(
            resultSet.getLong("id"),
            resultSet.getString("name")
        );
    }
}
