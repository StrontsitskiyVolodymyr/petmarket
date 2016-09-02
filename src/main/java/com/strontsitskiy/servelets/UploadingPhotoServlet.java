package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

@WebServlet("/upload")
@MultipartConfig
public class UploadingPhotoServlet extends HttpServlet {
    String path="C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("petid") == null) {
            InputStream inputStream = null;
            Part filepart = request.getPart("photo");
            inputStream = filepart.getInputStream();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            long date = new Date().getTime();
            String photoName = user.getId() + "photo" + date;
            File file = new File(path+"img/userphotos/" + photoName + ".jpg");
            OutputStream out = new FileOutputStream(path+"img/userphotos/" + photoName + ".jpg");
            if (user.getImg() != null) {
                File fordelete = new File(path+"img/userphotos/" + user.getImg());
                fordelete.delete();
            }
            byte[] buffer = new byte[1024];
            for (int n; (n = inputStream.read(buffer)) != -1; out.write(buffer, 0, n)) ;
            inputStream.close();
            out.close();
            DAOFactory daoFactory = DAOFactory.getInstance();
            user.setImg(photoName + ".jpg");
            UserDao userDao = daoFactory.getUserDao();
            userDao.update(user);
            response.sendRedirect("/useredit");
        } else {
            Long petid = new Long(request.getParameter("petid"));
            InputStream inputStream = null;
            Part filepart = request.getPart("petphoto");
            inputStream = filepart.getInputStream();
            DAOFactory daoFactory = DAOFactory.getInstance();
            PetDao petDao = daoFactory.getPetDao();
            Pet pet = petDao.getById(petid);
            long date = new Date().getTime();
            String photoName = pet.getId() + "photo" + date;
            File file = new File(path+"img/petphotos/" + photoName + ".jpg");
            OutputStream out = new FileOutputStream(path+"img/petphotos/" + photoName + ".jpg");
            if (pet.getImg() != null) {
                File fordelete = new File(path+"img/petphotos/" + pet.getImg());
                fordelete.delete();
            }
            byte[] buffer = new byte[1024];
            for (int n; (n = inputStream.read(buffer)) != -1; out.write(buffer, 0, n)) ;
            inputStream.close();
            out.close();
            pet.setImg(photoName + ".jpg");
            petDao.update(pet);
            response.sendRedirect("/pet?pet=" + pet.getId());
        }
    }
 }
