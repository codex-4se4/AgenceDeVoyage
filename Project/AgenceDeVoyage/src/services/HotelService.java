/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DBConnection;
import entities.Hotel;
import entities.MaisonHote;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jawher-Louisa
 */
public class HotelService implements IService<Hotel> {

    @Override
    public void ajouter(Hotel h) {
        String SQL1 = "INSERT INTO `hebergement` (`id`,`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("
                + h.getId() + "," + h.getNbChambres() + "," + h.getNbPersonnes() + "," + h.isAvecPiscine() + "," + h.isAvecParking() + "," + h.isAvecPlage() + ", '" + h.getAdresse() + "')";
        executeQuery(SQL1);
        String SQL2 = "INSERT INTO `hotel` (`id`,`nbEtoiles`) VALUES ("
                + h.getId() + " , " + h.getNbEtoiles() + ")";
        executeQuery(SQL2);
    }

    @Override
    public boolean supprimer(Hotel h) {
        String SQL1 = "DELETE FROM `hotel` WHERE id=" + h.getId();
        executeQuery(SQL1);
        String SQL2 = "DELETE FROM `hebergement` WHERE id=" + h.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public boolean modifier(Hotel h) {
        String SQL1 = "UPDATE `hebergement` SET nbChambres =" + h.getNbChambres() + ", nbPersonnes =" + h.getNbPersonnes()
                + ",avecPiscine =" + h.isAvecPiscine() + ",avecParking =" + h.isAvecParking() + ",avecPlage=" + h.isAvecPlage()
                + ",adresse='" + h.getAdresse() + "' WHERE id =" + h.getId();
        executeQuery(SQL1);
        String SQL2 = "UPDATE `hotel` SET nbEtoiles =" + h.getNbEtoiles()
                + " WHERE id =" + h.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public ObservableList<Hotel> consulter() {
        ObservableList<Hotel> hotels = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM hotel hotel inner join hebergement h on h.id = hotel.id";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Hotel hotel;
            while (rs.next()) {
                hotel = new Hotel(rs.getInt("nbEtoiles"), rs.getInt("id"), rs.getInt("nbChambres"), rs.getInt("nbPersonnes"), rs.getBoolean("avecPiscine"),
                        rs.getBoolean("avecParking"), rs.getBoolean("avecPlage"), rs.getString("adresse"));
                hotels.add(hotel);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hotels;
    }

}
