package com.alex.servlets;

import com.alex.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServletPage extends HttpServlet {
    private UserDAO userDAO= new UserDAO();

    @Override
    public void init() throws ServletException {
        Object usersO = getServletContext().getAttribute("dao");

        if (usersO == null) {
            throw new IllegalStateException("You are repository doesn't initialize!  222");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO=(UserDAO) req.getServletContext().getAttribute("dao");
        req.setAttribute("dao", userDAO);
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }
}
