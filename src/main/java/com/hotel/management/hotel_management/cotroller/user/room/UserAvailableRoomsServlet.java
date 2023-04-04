package com.hotel.management.hotel_management.cotroller.user.room;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet("/AvailableRoomsServlet")
public class UserAvailableRoomsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        int room_id = Integer.parseInt(request.getParameter("room_id"));
        float price_per_day = Float.parseFloat(request.getParameter("price_per_day"));

        request.setAttribute("checkInDate", checkInDate);
        request.setAttribute("checkOutDate", checkOutDate);
        request.setAttribute("room_id", room_id);
        request.setAttribute("price_per_day", price_per_day);

        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/user/room/user_reservation_room.jsp");
        reqDispatcher.forward(request, response);
    }
}
