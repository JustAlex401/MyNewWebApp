package com.alex.servlets;

import com.alex.dao.UserDAO;
import com.alex.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class RegistrationUserServlet extends HttpServlet {

    //private Map<Integer, User> userMap;
    AtomicReference<UserDAO> dao;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        Object userO=getServletContext().getAttribute("dao");
        if(userO==null || !(userO instanceof AtomicReference)){
            throw new IllegalStateException("RegistrationUserServlet userO null");
        }
//        else{
//            userMap.userList=(ConcurrentHashMap<Integer, User>) userO;
//        }
        id=new AtomicInteger(2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session=req.getSession();
        String login=req.getParameter("login");
        String password=req.getParameter("password");
//        session.setAttribute("login", login);
//        session.setAttribute("password", password);
        dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        if(login!=null && login.length() > 0 && password!=null && password.length() >0){
            User user=new User();
            int id=this.id.getAndIncrement();
            user.setId(id);
            user.setLogin(login);
            user.setPassword(password);
            dao.get().addUser(user);
        }
        System.out.println(req.getParameter("login"));
        System.out.println(req.getAttribute("login"));
        System.out.println(dao.toString());
        resp.sendRedirect(req.getContextPath()+"/");
    }
}
