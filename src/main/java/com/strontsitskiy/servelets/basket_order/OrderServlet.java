package com.strontsitskiy.servelets.basket_order;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetOrder;

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
    String path = "C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        OrderDao orderDao = daoFactory.getOrderDao();
        HttpSession session = request.getSession();
        Long id = new Long(request.getParameter("orderid"));
        PetOrder petOrder = orderDao.getById(id);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy");
        petOrder.setDate(simpleDateFormat.format(date));
        petOrder.setStatus("sold");
        orderDao.update(petOrder);
        PetDao petDao = daoFactory.getPetDao();
        Pet pet = petDao.getById(petOrder.getTargetPet().getId());
        petDao.remove(pet);

        Document document = new Document();   //under  only make pdf add forward on page with
        Rectangle rectangle = new Rectangle(600, 200);
        document.setPageSize(rectangle);
        Font[] fonts = {
                new Font(Font.FontFamily.COURIER, 18, Font.BOLD)
        };
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + "order.pdf"));
            document.open();
            Image image = Image.getInstance(path + "img/logo.png");
            document.add(image);
            Paragraph paragraph = new Paragraph();
            Paragraph paragraph2 = new Paragraph();
            Paragraph paragraph3 = new Paragraph();
            paragraph.setFont(fonts[0]);
            paragraph3.setFont(fonts[0]);
            paragraph.add("Price: " + petOrder.getTargetPet().getPrice() + "$ to " + petOrder.getOldOwner().getUserName() + " time " + simpleDateFormat.format(date));
            paragraph2.add("Delivery in " + request.getParameter("address") + "  " + request.getParameter("date"));
            paragraph3.add("Thanks for yoy order:)");
            document.add(paragraph);
            document.add(paragraph2);
            document.add(paragraph3);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/paymentinfo.jsp").forward(request, response);
    }
}
