package com.hotel.management.hotel_management.cotroller.receptionist.user;

import com.hotel.management.hotel_management.dao.users.UserDaoImpl;
import com.hotel.management.hotel_management.model.users.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReceptionistEditUserServlet", value = "/ReceptionistEditUserServlet")
public class ReceptionistEditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findById(id);

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userDao.update(user);

        request.setAttribute("user",user);

        request.getRequestDispatcher("views/receptionist/user/receptionist_details_user.jsp").forward(request,response);

    }
}
