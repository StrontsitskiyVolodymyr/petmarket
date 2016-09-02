package com.strontsitskiy.servelets.pet_service;

import com.strontsitskiy.dao.*;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class PetSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAOFactory daoFactory = DAOFactory.getInstance();
        PetDao petDao = daoFactory.getPetDao();
        if (request.getParameter("param") != null) {                                                                               //try  search by type or species
            TypeDao typeDao = daoFactory.getTypeDao();
            SpeciesDao speciesDao = daoFactory.getSpeciesDao();
            if (typeDao.getTypeByName(request.getParameter("param")) != null) {
                PetType petType = typeDao.getTypeByName(request.getParameter("param"));
                List<Pet> pets = petDao.getPetsByType(petType);
                session.setAttribute("pets", pets);
                request.getRequestDispatcher("petSearching.jsp").forward(request, response);
            } else {
                Species species = speciesDao.getSpeciesByName(request.getParameter("param"));
                List<Pet> pets = petDao.getPetsBySpecies(species);
                session.setAttribute("pets", pets);
                request.getRequestDispatcher("petSearching.jsp").forward(request, response);
            }
        } else if (request.getParameter("userid") != null) {                                                                  //if param==null try search by user
            UserDao userDao = daoFactory.getUserDao();
            Long id = new Long(request.getParameter("userid"));
            User user = userDao.getById(id);
            List<Pet> pets = petDao.getPetsByOwner(user);
            session.setAttribute("pets", pets);
            request.getRequestDispatcher("petSearching.jsp").forward(request, response);
        } else {                                                                                                                                            //if param==nul & user==null get all
            List<Pet> pets = petDao.getAll();
            session.setAttribute("pets", pets);
            request.getRequestDispatcher("petSearching.jsp").forward(request, response);
        }
    }
}
