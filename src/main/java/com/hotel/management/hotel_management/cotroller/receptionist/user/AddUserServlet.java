package com.hotel.management.hotel_management.cotroller.receptionist.user;

import com.hotel.management.hotel_management.dao.places.salles.SalleDaoImpl;
import com.hotel.management.hotel_management.dao.users.UserDaoImpl;
import com.hotel.management.hotel_management.model.places.Salle;
import com.hotel.management.hotel_management.model.users.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/receptionist/user/receptionist_add_user.jsp");


        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User(name, email, password);

        userDao.save(user);

        requestDispatcher.forward(request,response);
    }
}
