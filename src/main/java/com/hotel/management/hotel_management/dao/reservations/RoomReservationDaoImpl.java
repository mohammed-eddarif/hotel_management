package com.hotel.management.hotel_management.dao.reservations;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.others.ReservationRoom;
import com.hotel.management.hotel_management.model.places.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomReservationDaoImpl implements RoomReservationDao{
    @Override
    public ReservationRoom save(ReservationRoom reservationRoom) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO reservation_room (id_room, checkInDate, checkOutDate, fullName, email, phone) VALUES (?,?,?,?,?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reservationRoom.getId_room());
            ps.setDate(2, (java.sql.Date) reservationRoom.getCheckInDate());
            ps.setDate(3, (java.sql.Date) reservationRoom.getCheckOutDate());
            ps.setString(4, reservationRoom.getFullName());
            ps.setString(5, reservationRoom.getEmail());
            ps.setString(6, reservationRoom.getPhone());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                reservationRoom.setId(resultat.getInt(1));
                return reservationRoom;
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
        return null;
    }

    @Override
    public boolean remove(ReservationRoom reservationRoom) {
        return false;
    }

    @Override
    public ReservationRoom update(ReservationRoom reservationRoom) {
        return null;
    }

    @Override
    public ReservationRoom findById(int id) {
        return null;
    }

    @Override
    public List<ReservationRoom> findAll() {
        List<ReservationRoom> reservationRooms = new ArrayList<>() ;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM reservation_room ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    int id_room = r.getInt("id_room");
                    Date checkInDate = r.getDate("checkInDate");
                    Date checkOutDate = r.getDate("checkOutDate");
                    String fullName = r.getString("fullName");
                    String email = r.getString("email");
                    String phone = r.getString("phone");
                    reservationRooms.add(new ReservationRoom(id, id_room, checkInDate, checkOutDate, fullName, email, phone));
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
        return reservationRooms;
    }
}
