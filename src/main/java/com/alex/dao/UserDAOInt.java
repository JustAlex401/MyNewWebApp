package com.alex.dao;

import com.alex.model.Users;

public interface UserDAOInt {
    void addUser (Users user);
    boolean getUserByLoginPassword(String login, String password);
}
