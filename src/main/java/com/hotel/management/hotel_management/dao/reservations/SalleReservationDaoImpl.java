package com.hotel.management.hotel_management.dao.reservations;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.others.ReservationRoom;
import com.hotel.management.hotel_management.model.others.ReservationSalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalleReservationDaoImpl implements SalleReservationDao{
    @Override
    public ReservationSalle save(ReservationSalle reservationSalle) {
        return null;
    }

    @Override
    public boolean remove(ReservationSalle reservationSalle) {
        return false;
    }

    @Override
    public ReservationSalle update(ReservationSalle reservationSalle) {
        return null;
    }

    @Override
    public ReservationSalle findById(int id) {
        return null;
    }

    @Override
    public List<ReservationSalle> findAll() {
        List<ReservationSalle> reservationSalleList = new ArrayList<>() ;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM reservation_salle ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    Date checkInDate = r.getDate("checkInDate");
                    Date checkOutDate = r.getDate("checkOutDate");
                    String fullName = r.getString("fullName");
                    String email = r.getString("email");
                    String phone = r.getString("phone");
                    int id_salle = r.getInt("id_salle");

                    reservationSalleList.add(new ReservationSalle(id, id_salle, checkInDate, checkOutDate, fullName, email, phone));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return reservationSalleList;
    }
}
