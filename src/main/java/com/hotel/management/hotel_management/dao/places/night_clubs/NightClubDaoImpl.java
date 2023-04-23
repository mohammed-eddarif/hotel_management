package com.hotel.management.hotel_management.dao.places.night_clubs;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.places.NightClub;
import com.hotel.management.hotel_management.model.places.Pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NightClubDaoImpl implements NightClubDao{
    @Override
    public NightClub save(NightClub nightClub) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO night_club (nbr_places,price) VALUES (?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nightClub.getNbr_places());
            ps.setFloat(2, nightClub.getPrice());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                nightClub.setNight_club_id(resultat.getInt(1));
                return nightClub;
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
    public boolean remove(NightClub nightClub) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from night_club where id = ?;");
            ps.setInt(1, nightClub.getNight_club_id());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public NightClub update(NightClub nightClub) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE night_club SET nbr_places=?, price=? where id=?; ");
            ps.setInt(1, nightClub.getNbr_places());
            ps.setFloat(2, nightClub.getPrice());
            ps.setInt(3, nightClub.getNight_club_id());

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
        return nightClub;
    }

    @Override
    public NightClub findById(int idnc) {
        NightClub nightClub = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM `night_club` where `id`=?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, idnc);
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price");

                    nightClub = new NightClub(id, nbr_places, price);
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
        return nightClub;
    }

    @Override
    public List<NightClub> findAll() {
        List<NightClub> nightClubs = new ArrayList<>();
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM night_club ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price_per_day");

                    nightClubs.add(new NightClub(id, nbr_places, price));
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
        return nightClubs;
    }
}
