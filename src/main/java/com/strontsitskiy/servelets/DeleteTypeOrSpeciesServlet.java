package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.SpeciesDao;
import com.strontsitskiy.dao.TypeDao;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTypeOrSpeciesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory=DAOFactory.getInstance();
        if (request.getParameter("type") != null) {
            TypeDao typeDao=daoFactory.getTypeDao();
            Long id=new Long(request.getParameter("type"));
            PetType petType=typeDao.getById(id);
            typeDao.remove(petType);
            response.sendRedirect("/adminpage");
        }
        if  (request.getParameter("species") != null){
            SpeciesDao speciesDao=daoFactory.getSpeciesDao();
            Long id=new Long(request.getParameter("species"));
            Species species=speciesDao.getById(id);
            speciesDao.remove(species);
            response.sendRedirect("/adminpage");
        }
    }
}
