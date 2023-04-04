package com.hotel.management.hotel_management.cotroller.receptionist.salles;

import com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl;
import com.hotel.management.hotel_management.dao.places.salles.SalleDaoImpl;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.places.Salle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReceptionistDeleteSalleServlet", value = "/ReceptionistDeleteSalleServlet")
public class ReceptionistDeleteSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id_salle = Integer.parseInt(request.getParameter("id_salle"));

        SalleDaoImpl salleDao = new SalleDaoImpl();

        Salle salle = salleDao.findById(id_salle);

        salleDao.remove(salle);

        request.getRequestDispatcher("views/receptionist/salle/receptionist_manage_salle.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
