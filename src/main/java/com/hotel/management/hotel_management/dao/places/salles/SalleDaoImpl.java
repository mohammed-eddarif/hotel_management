package com.hotel.management.hotel_management.dao.places.salles;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.places.Salle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDaoImpl implements SalleDao{
    @Override
    public Salle save(Salle salle) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO salle (floor, nbr_places,price_per_day) VALUES (?,?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, salle.getFloor());
            ps.setInt(2, salle.getNbr_places());
            ps.setFloat(3, salle.getPrice_per_day());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                salle.setId_salle(resultat.getInt(1));
                return salle;
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
    public boolean remove(Salle salle) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from salle where id = ?;");
            ps.setInt(1, salle.getId_salle());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public Salle update(Salle salle) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE salle SET floor=?, nbr_places=?, price_per_day=? where id_salle=?; ");
            ps.setInt(1, salle.getFloor());
            ps.setInt(2, salle.getNbr_places());
            ps.setFloat(3, salle.getPrice_per_day());
            ps.setInt(4, salle.getId_salle());
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
        return salle;
    }

    @Override
    public Salle findById(int id) {
        Salle salle = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM `salle` where `id_salle`=?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, id);
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    int id_salle = r.getInt("id_salle");
                    int floor = r.getInt("floor");
                    int nbr_places = r.getInt("nbr_places");
                    float price_per_day = r.getFloat("price_per_day");

                    salle = new Salle(id_salle, floor, nbr_places, price_per_day);
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
        return salle;
    }

    @Override
    public List<Salle> findAll() {
        List<Salle> salles = new ArrayList<>();
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM salle ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id_salle = r.getInt("id_salle");
                    int floor = r.getInt("floor");
                    int nbr_places = r.getInt("nbr_places");
                    float price_per_day = r.getFloat("price_per_day");

                    salles.add(new Salle(id_salle, floor, nbr_places, price_per_day));
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
        return salles;
    }
}
