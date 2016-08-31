package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;
import com.strontsitskiy.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.getByEmail(request.getParameter("email"));
        String status;
        if (user != null) {
            if (user.getPassword().equals(MD5Util.md5Apache(request.getParameter("password")))) {
                status = "ok";
            } else {
                status = "wrongpass";
            }
        } else {
            status = "wrongemail";
        }
        String json = ("{ \"status\": \"" + status + "\" }");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
