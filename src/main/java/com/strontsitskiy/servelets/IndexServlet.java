package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;
import com.strontsitskiy.util.MD5Util;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.getByEmail(request.getParameter("email"));
        if (user.getPassword().equals(MD5Util.md5Apache(request.getParameter("password")))) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        response.sendRedirect("/index");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
