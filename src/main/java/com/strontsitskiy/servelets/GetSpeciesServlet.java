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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetSpeciesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TypeDao typeDao = daoFactory.getTypeDao();
        PetType petType = typeDao.getTypeByName(request.getParameter("currenttype"));
        SpeciesDao speciesDao = daoFactory.getSpeciesDao();
        List<Species> species = speciesDao.getSpeciesByType(petType);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < species.size()-1; i++) {
            stringBuffer.append("\"").append(species.get(i).getSpeciesName()).append("\": ").append("\"").append(species.get(i).getSpeciesName()).append("\", ");
        }
        stringBuffer.append("\"").append(species.get(species.size() - 1).getSpeciesName()).append("\": ").append("\"").append(species.get(species.size() - 1).getSpeciesName()).append("\"" + " }");
        String jsonObject = "{ "+stringBuffer;
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
