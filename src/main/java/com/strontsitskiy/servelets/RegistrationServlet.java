package com.strontsitskiy.servelets;

import com.strontsitskiy.Factory;

import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Factory factory = Factory.getInstance();
        UserDao userDao = factory.getUserDao();
        User user = new User();
        user.setUser(request.getParameter("user"));
        user.setEmail(request.getParameter("email"));
        user.setCity(request.getParameter("city"));
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password"));
        try {
            userDao.addUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
