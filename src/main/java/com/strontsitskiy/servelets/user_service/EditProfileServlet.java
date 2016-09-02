package com.strontsitskiy.servelets.user_service;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setUserName(request.getParameter("userName"));
        user.setCity(request.getParameter("city"));
        user.setPhone(request.getParameter("phone"));
        userDao.update(user);
        session.setAttribute("user", user);
        response.sendRedirect("/userpage?user="+user.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/userPageEdit.jsp").forward(request, response);
    }
}
