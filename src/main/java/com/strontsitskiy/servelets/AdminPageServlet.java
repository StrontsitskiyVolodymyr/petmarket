package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.*;

import com.strontsitskiy.models.PetOrder;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AdminPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        TypeDao typeDao = daoFactory.getTypeDao();
        SpeciesDao speciesDao = daoFactory.getSpeciesDao();
        OrderDao orderDao = daoFactory.getOrderDao();
        List<User> users = userDao.getAll();
        List<PetType> types = typeDao.getAll();
        List<Species> species = speciesDao.getAll();
        HttpSession session = request.getSession();
        List<PetOrder> orders = orderDao.getAll();
        session.setAttribute("users", users);
        session.setAttribute("types", types);
        session.setAttribute("species", species);
        session.setAttribute("orders", orders);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
