package com.strontsitskiy.servelets;

import com.strontsitskiy.models.User;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User();
        user.setUser(request.getParameter("user"));
        user.setEmail(request.getParameter("email"));
        user.setCity(request.getParameter("city"));
        user.setPhone(request.getParameter("phone"));
        session.setAttribute("user", user);

                response.sendRedirect("/");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
