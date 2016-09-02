package com.strontsitskiy.servelets.basket_order;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetOrder;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class IsInBasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        OrderDao orderDao = daoFactory.getOrderDao();
        HttpSession session = request.getSession();
        Pet pet = (Pet) session.getAttribute("pet");
        User user = (User) session.getAttribute("user");
        PetOrder petOrder = orderDao.getOrderByPetIdAndNewOwnerId(pet.getId(), user.getId());
        String status;
        if (petOrder != null) {
            status = "inbasket";
        } else {
            status = "isntinbasket";
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
