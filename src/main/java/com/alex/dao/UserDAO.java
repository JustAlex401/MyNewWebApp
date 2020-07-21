package com.alex.dao;

import com.alex.model.Users;
import com.alex.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements UserDAOInt {

    public void addUser(Users user){
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from users where login=:login and password=:password"); // When create query for select from table, need use name of table how name of entity
        query.setParameter("login", user.getLogin());
        query.setParameter("password", user.getPassword());
        if(query.list().isEmpty()){
            session.save(user);
        }
        transaction.commit();
        session.close();
    }

    public boolean getUserByLoginPassword(String login, String password){
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query=session.createQuery("from users where login=:login and password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        boolean res=!query.list().isEmpty();
        session.close();
        return res;
    }


}
