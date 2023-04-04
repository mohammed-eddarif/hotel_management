package com.hotel.management.hotel_management.cotroller.receptionist.salles;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.dao.places.salles.SalleDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.places.Salle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReceptionistEditSalleServlet", value = "/ReceptionistEditSalleServlet")
public class ReceptionistEditSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id_salle = Integer.parseInt(request.getParameter("id_salle"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int nbr_places = Integer.parseInt(request.getParameter("nbr_places"));
        float price_per_day = Float.parseFloat(request.getParameter("price_per_day"));

        SalleDaoImpl salleDao = new SalleDaoImpl();

        Salle salle = salleDao.findById(id_salle);

        salle.setFloor(floor);
        salle.setNbr_places(nbr_places);
        salle.setPrice_per_day(price_per_day);

        salleDao.update(salle);

        request.setAttribute("salle",salle);

        request.getRequestDispatcher("views/receptionist/salle/receptionist_details_salle.jsp").forward(request,response);

    }
}
