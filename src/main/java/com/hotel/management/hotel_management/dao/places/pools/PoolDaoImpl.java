package com.hotel.management.hotel_management.dao.places.pools;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.places.Pool;
import com.hotel.management.hotel_management.model.places.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoolDaoImpl implements PoolDao{
    @Override
    public Pool save(Pool pool) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO pool (nbr_places,price) VALUES (?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pool.getNbr_places());
            ps.setFloat(2, pool.getPrice());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                pool.setPool_id(resultat.getInt(1));
                return pool;
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
    public boolean remove(Pool pool) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from pool where id = ?;");
            ps.setInt(1, pool.getPool_id());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public Pool update(Pool pool) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE pool SET nbr_places=?, price=? where id=?; ");
            ps.setInt(1, pool.getNbr_places());
            ps.setFloat(2, pool.getPrice());
            ps.setInt(3, pool.getPool_id());

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
        return pool;
    }

    @Override
    public Pool findById(int idp) {
        Pool pool = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM `pool` where `id`=?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, idp);
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price");

                    pool = new Pool(id, nbr_places, price);
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
        return pool;
    }

    @Override
    public List<Pool> findAll() {
        List<Pool> pools = new ArrayList<>();
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM pool ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price_per_day");

                    pools.add(new Pool(id, nbr_places, price));
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
        return pools;
    }
}
