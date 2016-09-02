package com.strontsitskiy.servelets.basket_order;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetOrder;
import com.strontsitskiy.models.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        DAOFactory daoFactory = DAOFactory.getInstance();
        OrderDao orderDao = daoFactory.getOrderDao();
        PetOrder petOrder = new PetOrder();
        petOrder.setNewOwner(user);
        Pet pet = (Pet) session.getAttribute("pet");
        petOrder.setTargetPet(pet);
        petOrder.setOldOwner(pet.getOwner());
        orderDao.add(petOrder);
        String status = "nowinbasket";
        String json = ("{ \"status\": \"" + status + "\" }");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        OrderDao orderDao = daoFactory.getOrderDao();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<PetOrder> orders = orderDao.getByCreatorId(user.getId());
        session.setAttribute("orders", orders);
        request.getRequestDispatcher("/basket.jsp").forward(request, response);
    }
}
