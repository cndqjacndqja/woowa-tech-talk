package com.example.techtalk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.techtalk.db.DataBaseConnection;
import com.example.techtalk.entity.User;

public class UserDaoImpl implements UserDao {

    private static final String DATA_BASE_URL = "jdbc:h2:mem:testdb";

    private final DataSource dataSource =
        new DriverManagerDataSource(DATA_BASE_URL, "sa", "password");

    @Override
    public Long save(User user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dataSource.getConnection();

            String sql = "INSERT INTO user(name) values(?)";
            String[] generatedColumns = {"ID"};
            ps = con.prepareStatement(sql, generatedColumns);
            ps.setString(1, user.getName());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    @Override
    public User findById(Long id) {
        try (Connection con = DataBaseConnection.getConnection()) {
            String sql = "SELECT * FROM user WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                return new User(rs.getLong("id"),
                    rs.getString("name"));
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
