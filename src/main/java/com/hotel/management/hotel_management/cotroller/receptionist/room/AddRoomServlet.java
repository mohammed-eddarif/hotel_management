package com.hotel.management.hotel_management.cotroller.receptionist.room;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int floor = Integer.parseInt(request.getParameter("floor"));
        int nbr_places = Integer.parseInt(request.getParameter("nbr_places"));
        float price_per_day = Float.parseFloat(request.getParameter("price_per_day"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/receptionist/room/receptionist_add_room.jsp");


        Room room = new Room(floor, nbr_places, price_per_day);
        RoomDaoImpl roomDao = new RoomDaoImpl();

        roomDao.save(room);
        requestDispatcher.forward(request,response);
    }
}
