package com.alex.servlets;

import com.alex.dao.UserDAO;
import com.alex.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class LoginServlet extends HttpServlet {

    AtomicReference<UserDAO> dao;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        Object userO=getServletContext().getAttribute("dao");
        if(userO==null || !(userO instanceof AtomicReference)){
            throw new IllegalStateException("RegistrationUserServlet userO null");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session=req.getSession();
//        String login =(String) session.getAttribute("login");
//        String password= (String) session.getAttribute("password");
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        if(login!=null && login.length() > 0 && password!=null && password.length() >0){
            User user=dao.get().getUserByLoginPassword(login,password);
            if((user.getId())==-1){
                resp.sendRedirect(req.getContextPath()+"/");
            } else{
                req.getRequestDispatcher("/WEB-INF/pages/userPage.jsp").forward(req, resp);
            }
        }
    }

}
