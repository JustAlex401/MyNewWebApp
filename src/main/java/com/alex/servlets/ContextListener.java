package com.alex.servlets;

import com.alex.dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    private UserDAO userDAO=new UserDAO();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext =
                sce.getServletContext();

        servletContext.setAttribute("dao", userDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        userDAO=null;
    }
}
