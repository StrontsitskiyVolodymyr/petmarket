package com.strontsitskiy.servelets.basket_order;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


public class ReturnInfoInPDFServlet extends HttpServlet {
    String path = "C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/orders/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        File pdfFile = new File(path + session.getAttribute("curentOrderInfo"));


            ServletOutputStream op = response.getOutputStream();
            response.reset();
            response.setContentType("application/pdf");
            byte[] buf = new byte[4096];
            int length;
            DataInputStream in = new DataInputStream(new FileInputStream(pdfFile));
            while ((in != null) && ((length = in.read(buf)) != -1)) {
                op.write(buf, 0, length);
            }
            in.close();
            op.flush();
            op.close();
        }


}
