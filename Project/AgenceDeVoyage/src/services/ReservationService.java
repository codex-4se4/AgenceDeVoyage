/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reservation;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bourg
 */
public class ReservationService implements IService<Reservation> {

    @Override
    public void ajouter(Reservation r) {
        String SQL = "INSERT INTO `reservation` (`idr`, `prix`, `date_debut`,`date_fin`,`type`) VALUES (" + "'" + r.getIdr()+ "', '" + r.getPrix()+ "', '"
                + r.getDate_debut()+ "','" + r.getDate_fin()+ "','" + r.getType()+ "')";
        executeQuery(SQL);
    }

    @Override
    public boolean supprimer(Reservation r) {
        String SQL = "DELETE FROM `utilisateur` WHERE id=" + r.getId();
        executeQuery(SQL);
        return true;

    }

    @Override
    public boolean modifier(Reservation r) {
        String SQL = "UPDATE `reservation` SET idr ='" + r.getIdr()+ "', prix ='" + r.getPrix()
                + "',date_debut ='" + r.getDate_debut()+ "',date_fin ='" + r.getDate_fin()+ "',type='" + r.getType()
                 + "' WHERE id =" + r.getId();
        executeQuery(SQL);
        return true;
    }

    @Override
    public ObservableList<Reservation > consulter() {
        ObservableList<Reservation > Reservations = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `reservation`";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Reservation  reservation ;
            while (rs.next()) {
               reservation = new Reservation(rs.getInt("id"), rs.getInt("idr"), rs.getDouble("prix"), rs.getDate("date_debut"),
                        rs.getDate("date_fin"), rs.getString("type"));
                Reservations.add(reservation);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Reservations;

    }

    
}
