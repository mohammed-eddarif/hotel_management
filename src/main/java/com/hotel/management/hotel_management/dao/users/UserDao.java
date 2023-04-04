package com.hotel.management.hotel_management.dao.users;

import com.hotel.management.hotel_management.dao.Dao;
import com.hotel.management.hotel_management.model.users.User;

public interface UserDao extends Dao<User> {
    public User findByEmailAndPassword(String email, String password);
}
