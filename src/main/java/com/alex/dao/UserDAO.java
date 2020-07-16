package com.alex.dao;

import com.alex.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInterf{

    public List<User> userList=new ArrayList<>();

    public boolean addUser(User user){
        for (User user1: userList) {
            if (user1.getLogin().equals(user.getLogin()) && user1.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||"+user.getId());
        user.setId(userList.size()+1);
        return userList.add(user);
    }

    public User getUserByLoginPassword(String login, String password){
        User result =new User();
        result.setId(-1);
        for (User user:userList) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                result=user;
            }
        }
        return result;
    }


}
