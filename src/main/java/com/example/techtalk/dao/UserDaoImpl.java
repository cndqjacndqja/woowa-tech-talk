package com.example.techtalk.dao;

import com.example.techtalk.db.DataBaseConnection;
import com.example.techtalk.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public Long save(User user) throws SQLException {
        Connection con = DataBaseConnection.getConnection();
        PreparedStatement ps = null;
        try{
            String sql = "INSERT INTO user(name) values(?)";
            String generatedColumns[] = { "ID" };

            ps = con.prepareStatement(sql, generatedColumns);
            ps.setString(1, user.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return null;
        }catch (Exception e) {
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
        Connection con = DataBaseConnection.getConnection();
        try{
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
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
