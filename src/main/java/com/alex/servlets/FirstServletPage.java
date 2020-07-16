package com.alex.servlets;

import com.alex.dao.UserDAO;
import com.alex.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class FirstServletPage extends HttpServlet {

    //private Map<Integer, User> userMap;
    AtomicReference<UserDAO> dao;

    @Override
    public void init() throws ServletException {
        Object usersO = getServletContext().getAttribute("dao");

        if (usersO == null || !(usersO instanceof AtomicReference)) {
            throw new IllegalStateException("You are repository doesn't initialize!  222");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao=(AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");
        req.setAttribute("dao", dao);
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }
}
