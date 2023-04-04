package com.hotel.management.hotel_management.cotroller;

import com.hotel.management.hotel_management.dao.users.UserDaoImpl;
import com.hotel.management.hotel_management.model.users.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");


        User user = new User(name, email, password);
        UserDaoImpl userDao = new UserDaoImpl();

        userDao.save(user);
        requestDispatcher.forward(request,response);
    }
}
