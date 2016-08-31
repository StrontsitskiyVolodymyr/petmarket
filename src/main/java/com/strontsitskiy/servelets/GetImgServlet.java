package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.User;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class GetImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("kind").equals("u")) {
            Long userid = new Long(request.getParameter("userid"));
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDao userDao = daoFactory.getUserDao();
            User user = userDao.getById(userid);
            response.setContentType("image/jpg");
            File f = new File("C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/img/userphotos/" + user.getImg());
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        } else {
            Long petid = new Long(request.getParameter("petid"));
            DAOFactory daoFactory = DAOFactory.getInstance();
            PetDao petDao = daoFactory.getPetDao();
            Pet pet = petDao.getById(petid);
            response.setContentType("image/jpg");
            File f = new File("C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/img/petphotos/" + pet.getImg());
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        }


    }
}
