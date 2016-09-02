package com.strontsitskiy.servelets.user_service;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;
import com.strontsitskiy.util.MD5Util;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        User user = new User();
        user.setUserName(request.getParameter("user"));
        user.setEmail(request.getParameter("email"));
        user.setCity(request.getParameter("city"));
        user.setPhone(request.getParameter("phone"));
        if (request.getParameter("shop").equals("on")) {
            user.setUserRole("shop");
        }
        user.setPassword(MD5Util.md5Apache(request.getParameter("password")));
        userDao.add(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("/index");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
