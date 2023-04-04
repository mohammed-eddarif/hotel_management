package com.hotel.management.hotel_management.cotroller;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.dao.users.UserDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.users.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String receptionist_email = "receptionist@gmail.com";
        String receptionist_password = "receptionist";

        HttpSession session = request.getSession();

        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByEmailAndPassword(email, password);


        RequestDispatcher requestDispatcher;
        if (user != null){
            session.setAttribute("email", email);
            requestDispatcher = request.getRequestDispatcher("views/user/user_home.jsp");

        } else if ((email.equals(receptionist_email)) && (password.equals(receptionist_password))) {
            requestDispatcher = request.getRequestDispatcher("views/receptionist/receptionist_home.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("login.jsp");
        }
        requestDispatcher.forward(request,response);


    }
}
