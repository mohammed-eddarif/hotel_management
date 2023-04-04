package com.hotel.management.hotel_management.cotroller.receptionist.room;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReceptionistDeleteRoomServlet", value = "/ReceptionistDeleteRoomServlet")
public class ReceptionistDeleteRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int room_id = Integer.parseInt(request.getParameter("id"));

        RoomDaoImpl roomDao = new RoomDaoImpl();

        Room room = roomDao.findById(room_id);

        roomDao.remove(room);

        request.getRequestDispatcher("views/receptionist/receptionist_home.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
