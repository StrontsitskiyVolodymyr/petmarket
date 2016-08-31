package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeletePetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        PetDao petDao = daoFactory.getPetDao();
        Long id = new Long(request.getParameter("petid"));
        Pet pet = petDao.getById(id);
        petDao.remove(pet);
        response.sendRedirect("/index");
    }
}
