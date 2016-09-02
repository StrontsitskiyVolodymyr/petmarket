package com.strontsitskiy.servelets.basket_order;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.models.PetOrder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =new Long(request.getParameter("id"));
        DAOFactory daoFactory=DAOFactory.getInstance();
        OrderDao orderDao=daoFactory.getOrderDao();
        PetOrder petOrder=orderDao.getById(id);
        orderDao.remove(petOrder);
       response.sendRedirect("/basket");
    }
}
