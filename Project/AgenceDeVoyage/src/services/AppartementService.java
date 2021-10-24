/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DBConnection;
import entities.Appartement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jawher-Louisa
 */
public class AppartementService implements IService<Appartement> {

    @Override
    public void ajouter(Appartement a) {
        String SQL1 = "INSERT INTO `hebergement` (`id`,`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("
                + a.getId() + "," + a.getNbChambres() + "," + a.getNbPersonnes() + "," + a.isAvecPiscine() + "," + a.isAvecParking() + "," + a.isAvecPlage() + ", '" + a.getAdresse() + "')";
        executeQuery(SQL1);
        String SQL2 = "INSERT INTO `appartement` (`id`,`numeroEtage`, `avecAscenseur`) VALUES ("
                + a.getId() + " , " + a.getNumeroEtage() + " , " + a.isAvecAscenseur() + ")";
        executeQuery(SQL2);
    }

    @Override
    public boolean supprimer(Appartement a) {
        String SQL1 = "DELETE FROM `appartement` WHERE id=" + a.getId();
        executeQuery(SQL1);
        String SQL2 = "DELETE FROM `hebergement` WHERE id=" + a.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public boolean modifier(Appartement a) {
        String SQL1 = "UPDATE `hebergement` SET nbChambres =" + a.getNbChambres() + ", nbPersonnes =" + a.getNbPersonnes()
                + ",avecPiscine =" + a.isAvecPiscine() + ",avecParking =" + a.isAvecParking() + ",avecPlage=" + a.isAvecPlage()
                + ",adresse='" + a.getAdresse() + "' WHERE id =" + a.getId();
        executeQuery(SQL1);
        String SQL2 = "UPDATE `appartement` SET numeroEtage =" + a.getNumeroEtage() + ", avecAscenseur =" + a.isAvecAscenseur()
                + " WHERE id =" + a.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public ObservableList<Appartement> consulter() {
        ObservableList<Appartement> appartements = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM appartement a inner join hebergement h on h.id = a.id";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Appartement appartement;
            while (rs.next()) {
                appartement = new Appartement(rs.getInt("numeroEtage"), rs.getBoolean("avecAscenseur"), rs.getInt("id"), rs.getInt("nbChambres"), rs.getInt("nbPersonnes"), rs.getBoolean("avecPiscine"),
                        rs.getBoolean("avecParking"), rs.getBoolean("avecPlage"), rs.getString("adresse"));
                appartements.add(appartement);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return appartements;
    }

}
