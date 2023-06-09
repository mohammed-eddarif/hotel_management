package com.hotel.management.hotel_management.cotroller.user;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.dao.places.salles.SalleDaoImpl;
import com.hotel.management.hotel_management.dao.reservations.RoomReservationDaoImpl;
import com.hotel.management.hotel_management.dao.reservations.SalleReservationDaoImpl;
import com.hotel.management.hotel_management.model.others.ReservationRoom;
import com.hotel.management.hotel_management.model.others.ReservationSalle;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.places.Salle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        String reservation_type = request.getParameter("reservation_type");


        request.setAttribute("checkInDate", checkInDate);
        request.setAttribute("checkOutDate", checkOutDate);


        RoomDaoImpl roomDao = new RoomDaoImpl();
        RoomReservationDaoImpl roomReservationDao = new RoomReservationDaoImpl();

        List<Room> availableRooms = roomDao.findAll();
        List<ReservationRoom> reservations = roomReservationDao.findAll();


        SalleDaoImpl salleDao = new SalleDaoImpl();
        SalleReservationDaoImpl salleReservationDao = new SalleReservationDaoImpl();

        List<Salle> availableSalles = salleDao.findAll();
        List<ReservationSalle> reservationSalleList = salleReservationDao.findAll();



        for (ReservationRoom reservation : reservations) {
            if ((isDateAfterThan(checkOutDate, reservation.getCheckInDate().toString())) || (isDateAfterThan(reservation.getCheckOutDate().toString(), checkInDate)))
            {
                for (int j = 0; j < availableRooms.size(); j++) {
                    if (reservation.getId_room() == availableRooms.get(j).getRoom_id()) {
                        availableRooms.remove(j);
                        break;
                    }
                }
            }
        }

        for (ReservationSalle reservationSalle : reservationSalleList) {
            if ((isDateAfterThan(checkOutDate, reservationSalle.getCheckInDate().toString())) || (isDateAfterThan(reservationSalle.getCheckOutDate().toString(), checkInDate)))
            {
                for (int j = 0; j < availableSalles.size(); j++) {
                    if (reservationSalle.getId_salle() == availableSalles.get(j).getId_salle()) {
                        availableSalles.remove(j);
                        break;
                    }
                }
            }
        }

        if (reservation_type.equals("room")) {
            request.setAttribute("availableRooms", availableRooms);

            RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/user/room/user_available_room.jsp");
            reqDispatcher.forward(request, response);
        } else if (reservation_type.equals("salle")) {
            request.setAttribute("availableSalles", availableSalles);

            request.getRequestDispatcher("/views/user/salle/user_available_salle.jsp").forward(request,response);


        }


    }

    private boolean isDateAfterThan(String firstDate, String secondDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf.parse(firstDate);
            Date date2 = sdf.parse(secondDate);
            return date1.compareTo(date2) > 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
