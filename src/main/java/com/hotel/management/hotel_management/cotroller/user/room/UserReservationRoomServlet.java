package com.hotel.management.hotel_management.cotroller.user.room;

import com.hotel.management.hotel_management.dao.reservations.RoomReservationDaoImpl;
import com.hotel.management.hotel_management.model.others.ReservationRoom;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserReservationRoomServlet", value = "/UserReservationRoomServlet")
public class UserReservationRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int room_id = Integer.parseInt(request.getParameter("room_id"));
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date11 = null;
        try {
            date11 = sdf1.parse(checkInDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date date22 = null;
        try {
            date22 = sdf1.parse(checkOutDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        java.sql.Date date1 = new java.sql.Date(date11.getTime());
        java.sql.Date date2 = new java.sql.Date(date22.getTime());

        ReservationRoom reservationRoom = new ReservationRoom(room_id, date1, date2, fullName, email, phone);

        RoomReservationDaoImpl roomReservationDao = new RoomReservationDaoImpl();

        roomReservationDao.save(reservationRoom);

        request.getRequestDispatcher("/views/user/user_home.jsp").forward(request, response);

    }
}
