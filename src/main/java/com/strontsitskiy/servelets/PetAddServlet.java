package com.strontsitskiy.servelets;

import com.strontsitskiy.dao.DAOFactory;
import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.dao.SpeciesDao;
import com.strontsitskiy.dao.TypeDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;
import com.strontsitskiy.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class PetAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Pet pet = new Pet();
        pet.setOwner(user);
        DAOFactory daoFactory = DAOFactory.getInstance();
        TypeDao typeDao = daoFactory.getTypeDao();
        PetType petType = new PetType();
        if (request.getParameter("typeselect").equals("notype")) {
            petType.setTypeName(request.getParameter("newtype"));
            pet.setPetType(petType);
            typeDao.add(petType);
        } else {
            pet.setPetType(typeDao.getTypeByName(request.getParameter("typeselect")));
            petType = typeDao.getTypeByName(request.getParameter("typeselect"));
        }
        SpeciesDao speciesDao = daoFactory.getSpeciesDao();
        Species species = new Species();
        if (request.getParameter("speciesa").equals("nospecies")) {
            species.setSpeciesName(request.getParameter("newspecies"));
            species.setParentType(petType);
            speciesDao.add(species);
            pet.setSpecies(species);
        } else {
            pet.setSpecies(speciesDao.getSpeciesByName(request.getParameter("speciesa")));
        }
        pet.setDescription(request.getParameter("description"));
        pet.setSex(request.getParameter("sex"));
        Integer price = new Integer(request.getParameter("price"));
        pet.setPrice(price);
        PetDao petDao = daoFactory.getPetDao();
        petDao.add(pet);
        response.sendRedirect("/pet?pet=" + pet.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAOFactory daoFactory = DAOFactory.getInstance();
        TypeDao typeDao = daoFactory.getTypeDao();
        List<PetType> petTypes = typeDao.getAll();
        session.setAttribute("pettypes", petTypes);
        request.getRequestDispatcher("petAdding.jsp").forward(request, response);
    }
}
