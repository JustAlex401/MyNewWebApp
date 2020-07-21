package com.alex.utils;

import com.alex.model.Users;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Users.class);
                StandardServiceRegistryBuilder standardServiceRegistryBuilder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory=configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
