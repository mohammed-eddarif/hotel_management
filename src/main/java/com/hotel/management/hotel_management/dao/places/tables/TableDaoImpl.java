package com.hotel.management.hotel_management.dao.places.tables;

import com.hotel.management.hotel_management.configuration.MySqlConnection;
import com.hotel.management.hotel_management.model.places.Room;
import com.hotel.management.hotel_management.model.places.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TableDao{
    @Override
    public Table save(Table table) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO tablee (nbr_places,price) VALUES (?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, table.getNbr_places());
            ps.setFloat(2, table.getPrice());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                table.setTable_id(resultat.getInt(1));
                return table;
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
    public boolean remove(Table table) {
        boolean rowDeleted;
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("delete from tablee where id = ?;");
            ps.setInt(1, table.getTable_id());
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public Table update(Table table) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE tablee SET nbr_places=?, price=? where id=?; ");
            ps.setInt(1, table.getNbr_places());
            ps.setFloat(2, table.getPrice());
            ps.setInt(3, table.getTable_id());

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
        return table;
    }

    @Override
    public Table findById(int idt) {
        Table table = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM `tablee` where `id`=?;";
                PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, idt);
                ResultSet r = ps.executeQuery();
                if (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price");

                    table = new Table(id, nbr_places, price);
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
        return table;
    }

    @Override
    public List<Table> findAll() {
        List<Table> tables = new ArrayList<>();
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM tablee ;";
                PreparedStatement ps = c.prepareStatement(request);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    int id = r.getInt("id");
                    int nbr_places = r.getInt("nbr_places");
                    float price = r.getFloat("price_per_day");

                    tables.add(new Table(id, nbr_places, price));
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
        return tables;
    }
}
