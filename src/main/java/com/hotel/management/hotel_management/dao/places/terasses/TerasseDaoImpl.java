package com.hotel.management.hotel_management.dao.places.terasses;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.places.NightClub;
import com.hotel.management.hotel_management.model.places.Terasse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TerasseDaoImpl implements TerasseDao{
    @Override
    public Terasse save(Terasse terasse) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO terasse (nbr_places,price) VALUES (?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, terasse.getNbr_places());
            ps.setFloat(2, terasse.getPrice());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                terasse.setTable_id(resultat.getInt(1));
                return terasse;
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
    public boolean remove(Terasse terasse) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from terasse where id = ?;");
            ps.setInt(1, terasse.getTerasse_id());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public Terasse update(Terasse terasse) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE terasse SET nbr_places=?, price=? where id=?; ");
            ps.setInt(1, terasse.getNbr_places());
            ps.setFloat(2, terasse.getPrice());
            ps.setInt(3, terasse.getTerasse_id());

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
        return terasse;
    }

    @Override
    public Terasse findById(int idt) {
        Terasse terasse = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM `terasse` where `id`=?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, idt);
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price");

                    terasse = new Terasse(id, nbr_places, price);
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
        return terasse;
    }

    @Override
    public List<Terasse> findAll() {
        List<Terasse> terasses = new ArrayList<>();
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM terasse ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price_per_day");

                    terasses.add(new Terasse(id, nbr_places, price));
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
        return terasses;
    }
}
