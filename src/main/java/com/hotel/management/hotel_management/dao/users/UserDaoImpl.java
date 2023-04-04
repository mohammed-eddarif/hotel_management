package com.hotel.management.hotel_management.dao.users;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public User save(User user) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO user (name, email,password) VALUES (?,?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                user.setId(resultat.getInt(1));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean remove(User user) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from user where id = ?;");
            ps.setInt(1, user.getId());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM user WHERE id = ?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, id);
                ResultSet r = ps.executeQuery();
                if (r.next())
                    user = new User(r.getInt("id"), r.getString("name"), r.getString("email"), r.getString("password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>() ;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM user ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    String name = r.getString("name");
                    String email = r.getString("email");
                    String password = r.getString("password");
                    users.add(new User(id, name, email, password));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM user WHERE email = ? and password = ?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet r = ps.executeQuery();
                if (r.next())
                    user = new User(r.getInt("id"), r.getString("name"), r.getString("email"), r.getString("password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
