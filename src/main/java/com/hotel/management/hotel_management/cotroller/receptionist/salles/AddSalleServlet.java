package com.hotel.management.hotel_management.cotroller.receptionist.salles;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.dao.places.salles.SalleDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.places.Salle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/AddSalleServlet")
public class AddSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int floor = Integer.parseInt(request.getParameter("floor"));
        int nbr_places = Integer.parseInt(request.getParameter("nbr_places"));
        float price_per_day = Float.parseFloat(request.getParameter("price_per_day"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/receptionist/salle/receptionist_add_salle.jsp");


        Salle salle = new Salle(floor, nbr_places, price_per_day);
        SalleDaoImpl salleDao = new SalleDaoImpl();

        salleDao.save(salle);
        requestDispatcher.forward(request,response);
    }
}
