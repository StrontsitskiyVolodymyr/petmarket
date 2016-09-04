package com.strontsitskiy.servelets.basket_order;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetOrder;
import com.strontsitskiy.util.PDF;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        OrderDao orderDao = daoFactory.getOrderDao();
        Long id = new Long(request.getParameter("orderid"));
        PetOrder petOrder = orderDao.getById(id);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy");
        petOrder.setDate(simpleDateFormat.format(date));
        petOrder.setStatus("done");
        orderDao.update(petOrder);
        PetDao petDao = daoFactory.getPetDao();
        Pet pet = petDao.getById(petOrder.getTargetPet().getId());
        pet.setStatus("sold");
        petDao.update(pet);
        PDF pdf = new PDF();
        String address = request.getParameter("address");
        String dateDilivery = request.getParameter("date");
        int price = petOrder.getTargetPet().getPrice();
        String nameOfOwner = petOrder.getOldOwner().getUserName();
        pdf.create(address, dateDilivery, price, nameOfOwner, petOrder.getTargetPet().getId().toString());
        HttpSession session = request.getSession();
        String curentOrderInfo = "oder" + petOrder.getTargetPet().getId() + ".pdf";
        session.setAttribute("curentOrderInfo", curentOrderInfo);
        request.getRequestDispatcher("/paymentinfo.jsp").forward(request, response);
    }
}
