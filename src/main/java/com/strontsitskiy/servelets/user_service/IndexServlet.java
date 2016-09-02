package com.strontsitskiy.servelets.user_service;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.User;
import com.strontsitskiy.util.MD5Util;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.getByEmail(request.getParameter("email"));
        HttpSession session = request.getSession();
        if (user.getPassword().equals(MD5Util.md5Apache(request.getParameter("password")))) {
            session.setAttribute("user", user);
        }
        response.sendRedirect((String) session.getAttribute("currentpagesign"));

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        PetDao petDao = daoFactory.getPetDao();
        List<Pet> pets = petDao.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("addedpets", pets);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
