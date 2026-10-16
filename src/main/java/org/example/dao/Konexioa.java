package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

    private static final String URL =
            "jdbc:mysql://localhost:3306/AnimalienBabeslekua";

    private static final String USER = "unaxm";
    private static final String PASSWORD = "unaxm";

    public static Connection konektatu() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}