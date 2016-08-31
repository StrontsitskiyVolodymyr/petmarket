package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        HttpSession session = request.getSession();
        if (request.getParameter("id") != null) {
           Long id =new Long(request.getParameter("id"));
            User user =userDao.getById(id);
            userDao.remove(user);
            response.sendRedirect("/adminpage");
        } else {
            User user = (User) session.getAttribute("user");
            userDao.remove(user);
            session.invalidate();
            response.sendRedirect("/index");
        }


    }
}
