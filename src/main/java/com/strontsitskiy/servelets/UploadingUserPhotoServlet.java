package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/upload")
@MultipartConfig
public class UploadingUserPhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = null;
        Part filepart=request.getPart("photo");
        inputStream =filepart.getInputStream();
        HttpSession session=request.getSession();
        User user =(User)session.getAttribute("user");
        String photoName= "photo"+user.getId();
        File file = new File("C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/img/userphotos/"+photoName+".jpg");
        OutputStream out = new FileOutputStream("C:/Users/i/Desktop/ВебМаг/Shop/src/main/webapp/img/userphotos/"+photoName+".jpg");
        byte[] buffer = new byte[1024];
        for (int n;(n = inputStream.read(buffer)) != -1; out.write(buffer, 0, n));
        inputStream.close();
        out.close();
        DAOFactory daoFactory = DAOFactory.getInstance();
        user.setImg(photoName+".jpg");
        UserDao userDao = daoFactory.getUserDao();
        userDao.update(user);
        response.sendRedirect("/useredit");
    }


}
