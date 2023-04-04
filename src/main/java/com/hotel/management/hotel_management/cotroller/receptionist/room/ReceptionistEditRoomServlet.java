package com.hotel.management.hotel_management.cotroller.receptionist.room;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReceptionistEditRoomServlet", value = "/ReceptionistEditRoomServlet")
public class ReceptionistEditRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int room_id = Integer.parseInt(request.getParameter("id"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int nbr_places = Integer.parseInt(request.getParameter("nbr_places"));
        float price_per_day = Float.parseFloat(request.getParameter("price_per_day"));

        RoomDaoImpl roomDao = new RoomDaoImpl();

        Room room = roomDao.findById(room_id);

        room.setFloor(floor);
        room.setNbr_places(nbr_places);
        room.setPrice_per_day(price_per_day);

        roomDao.update(room);

        request.setAttribute("room",room);

        request.getRequestDispatcher("views/receptionist/room/receptionist_details_room.jsp").forward(request,response);
    }
}
