package com.strontsitskiy.servelets.badges;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.OrderDao;
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
import java.util.List;

public class CountOfOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        OrderDao orderDao=daoFactory.getOrderDao();
        HttpSession session=request.getSession();
       User user=(User)session.getAttribute("user") ;
        List<PetOrder> orders= orderDao.getByCreatorId(user.getId());
        int numberOfOrdersInBasket=0;
                for (PetOrder order : orders) {
            if (!order.getStatus().equals("sold")) numberOfOrdersInBasket+=1;
        }        String json = ("{ \"count\": \"" + numberOfOrdersInBasket+ "\" }");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
