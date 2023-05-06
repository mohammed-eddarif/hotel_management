package com.hotel.management.hotel_management.cotroller.maitre_ouvrage.night_club;

import com.hotel.management.hotel_management.dao.places.night_clubs.NightClubDaoImpl;
import com.hotel.management.hotel_management.model.places.NightClub;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/AddNightClubServlet")
public class AddNightClubServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int nbr_places = Integer.parseInt(request.getParameter("nbr_places"));
        float price = Float.parseFloat(request.getParameter("price"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/maitreOuvrage/night-club/maitreOuvrage_manage_night-club.jsp");

        NightClubDaoImpl nightClubDao = new NightClubDaoImpl();
        NightClub nightClub = new NightClub(nbr_places,price);

        nightClubDao.save(nightClub);

        requestDispatcher.forward(request,response);
    }
}
