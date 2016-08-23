package com.strontsitskiy.dao;

import com.strontsitskiy.models.User;

import java.sql.SQLException;

public interface UserDao {
    public void addUser(User user)throws SQLException;
    public void deleteUser(User user)throws SQLException;
    public User getUser(String email)throws SQLException;
}
