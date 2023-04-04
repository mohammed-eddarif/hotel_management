package com.hotel.management.hotel_management.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    private MySqlConnection() { }
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/hotel_management?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String utilisateur = "root";
            String motDePasse = "drif0624414225";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("couldn't connect!");
            throw new RuntimeException(e);
        }
    }
}
