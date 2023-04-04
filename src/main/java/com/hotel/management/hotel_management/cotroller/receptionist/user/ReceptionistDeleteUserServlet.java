package com.hotel.management.hotel_management.cotroller.receptionist.user;

import com.hotel.management.hotel_management.dao.users.UserDaoImpl;
import com.hotel.management.hotel_management.model.users.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReceptionistDeleteUserServlet", value = "/ReceptionistDeleteUserServlet")
public class ReceptionistDeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        UserDaoImpl userDao = new UserDaoImpl();

        User user = userDao.findById(id);

        userDao.remove(user);

        request.getRequestDispatcher("views/receptionist/user/receptionist_manage_user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
