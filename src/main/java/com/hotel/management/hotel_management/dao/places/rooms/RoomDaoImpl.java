package com.hotel.management.hotel_management.dao.places.rooms;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.places.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public Room save(Room room) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO room (floor, nbr_places,price_per_day,is_reserved) VALUES (?,?,?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, room.getFloor());
            ps.setInt(2, room.getNbr_places());
            ps.setFloat(3, room.getPrice_per_day());
            ps.setBoolean(4, room.getIs_reserved());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                room.setRoom_id(resultat.getInt(1));
                return room;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean remove(Room room) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from room where id = ?;");
            ps.setInt(1, room.getRoom_id());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public Room update(Room room) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE room SET floor=?, nbr_places=?, price_per_day=? where id=?; ");
            ps.setInt(1, room.getFloor());
            ps.setInt(2, room.getNbr_places());
            ps.setFloat(3, room.getPrice_per_day());
            ps.setInt(4, room.getRoom_id());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return room;
    }

    @Override
    public Room findById(int idr) {
        Room room = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM `room` where `id`=?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, idr);
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    int id = r.getInt("id");
                    int floor = r.getInt("floor");
                    int nbr_places = r.getInt("nbr_places");
                    float price_per_day = r.getFloat("price_per_day");

                    room = new Room(id, floor, nbr_places, price_per_day);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return room;
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM room ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    int floor = r.getInt("floor");
                    int nbr_places = r.getInt("nbr_places");
                    float price_per_day = r.getFloat("price_per_day");

                    rooms.add(new Room(id, floor, nbr_places, price_per_day));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rooms;
    }
}
