package org.example.dao;

import org.example.dao.Konexioa;
import org.example.model.Animalia;
import org.example.model.Katua;
import org.example.model.Txakurra;
import org.example.model.Untxia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnimaliaDAO {

    public void insertar(Animalia animalia) {

        String sql = "INSERT INTO animalia " +
                "(izena, adina, pisua, mota, adoptatua) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection konexioa = Konexioa.konektatu();
             PreparedStatement ps = konexioa.prepareStatement(sql)) {

            ps.setString(1, animalia.getIzena());
            ps.setInt(2, animalia.getAdina());
            ps.setDouble(3, animalia.getPisua());
            ps.setString(4, animalia.getEspeziea());
            ps.setBoolean(5, animalia.getAdoptatua());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Animalia> lortuAnimaliak() {

        ArrayList<Animalia> animaliak = new ArrayList<>();

        String sql = "SELECT * FROM animalia";

        try (Connection konexioa = Konexioa.konektatu();
             PreparedStatement ps = konexioa.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                String izena = rs.getString("izena");
                int adina = rs.getInt("adina");
                double pisua = rs.getDouble("pisua");
                String mota = rs.getString("mota");
                boolean adoptatua = rs.getBoolean("adoptatua");

                Animalia animalia;

                if (mota.equals("Katua")) {
                    animalia = new Katua(izena, adina, pisua);
                } else if (mota.equals("Txakurra")) {
                    animalia = new Txakurra(izena, adina, pisua);
                } else {
                    animalia = new Untxia(izena, adina, pisua);
                }

                animalia.setAdoptatua(adoptatua);

                animaliak.add(animalia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return animaliak;
    }

    public boolean ezabatu(String izena) {

        String sql = "DELETE FROM animalia WHERE izena = ?";

        try (Connection konexioa = Konexioa.konektatu();
             PreparedStatement ps = konexioa.prepareStatement(sql)) {

            ps.setString(1, izena);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean adoptatu(String izena) {

        String sql = "UPDATE animalia SET adoptatua = TRUE WHERE izena = ?";

        try (Connection konexioa = Konexioa.konektatu();
             PreparedStatement ps = konexioa.prepareStatement(sql)) {

            ps.setString(1, izena);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}