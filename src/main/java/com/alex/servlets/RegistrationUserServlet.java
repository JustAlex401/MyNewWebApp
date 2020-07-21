package com.alex.servlets;

import com.alex.dao.UserDAO;
import com.alex.model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationUserServlet extends HttpServlet {
    private UserDAO userDAO=new UserDAO();
    @Override
    public void init() throws ServletException {
        Object userO=getServletContext().getAttribute("dao");
        if(userO==null ){
            throw new IllegalStateException("RegistrationUserServlet userO null");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        userDAO =(UserDAO) req.getServletContext().getAttribute("dao");

        if(login!=null && login.length() > 0 && password!=null && password.length() >0){
            Users user=new Users();
            user.setLogin(login);
            user.setPassword(password);
            userDAO.addUser(user);
            req.setAttribute("dao", userDAO);
        }
        resp.sendRedirect(req.getContextPath()+"/");
    }
}
