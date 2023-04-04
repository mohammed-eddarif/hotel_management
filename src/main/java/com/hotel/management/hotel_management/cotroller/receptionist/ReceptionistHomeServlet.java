package com.hotel.management.hotel_management.cotroller.receptionist;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDao;
import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/ReceptionistHomeServlet")
public class ReceptionistHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("views/receptionist/room/receptionist_manage_room.jsp").forward(request,response);

    }
}
