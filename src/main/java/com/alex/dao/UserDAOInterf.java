package com.alex.dao;

import com.alex.model.User;

public interface UserDAOInterf {
    boolean addUser (User user);
    User getUserByLoginPassword(String login, String password);
}
