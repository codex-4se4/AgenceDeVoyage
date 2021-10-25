/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DBConnection;
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
public class MaisonHoteService implements IService<MaisonHote> {

    @Override
    public void ajouter(MaisonHote mh) {
        String SQL1 = "INSERT INTO `hebergement` (`id`,`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("
                + mh.getId() + "," + mh.getNbChambres() + "," + mh.getNbPersonnes() + "," + mh.isAvecPiscine() + "," + mh.isAvecParking() + "," + mh.isAvecPlage() + ", '" + mh.getAdresse() + "')";
        executeQuery(SQL1);
        String SQL2 = "INSERT INTO `maisonHote` (`id`,`avecPetitDejInclus`) VALUES ("
                + mh.getId() + " , " + mh.isAvecPetitDejInclus() + ")";
        executeQuery(SQL2);
    }

    @Override
    public boolean supprimer(MaisonHote mh) {
        String SQL1 = "DELETE FROM `maisonHote` WHERE id=" + mh.getId();
        executeQuery(SQL1);
        String SQL2 = "DELETE FROM `hebergement` WHERE id=" + mh.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public boolean modifier(MaisonHote mh) {
        String SQL1 = "UPDATE `hebergement` SET nbChambres =" + mh.getNbChambres() + ", nbPersonnes =" + mh.getNbPersonnes()
                + ",avecPiscine =" + mh.isAvecPiscine() + ",avecParking =" + mh.isAvecParking() + ",avecPlage=" + mh.isAvecPlage()
                + ",adresse='" + mh.getAdresse() + "' WHERE id =" + mh.getId();
        executeQuery(SQL1);
        String SQL2 = "UPDATE `maisonHote` SET avecPetitDejInclus =" + mh.isAvecPetitDejInclus()
                + " WHERE id =" + mh.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public ObservableList<MaisonHote> consulter() {
        ObservableList<MaisonHote> maisonHotes = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM MaisonHote mh inner join hebergement h on h.id = mh.id";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            MaisonHote maisonHote;
            while (rs.next()) {
                maisonHote = new MaisonHote(rs.getBoolean("avecPetitDejInclus"), rs.getInt("id"), rs.getInt("nbChambres"), rs.getInt("nbPersonnes"), rs.getBoolean("avecPiscine"),
                        rs.getBoolean("avecParking"), rs.getBoolean("avecPlage"), rs.getString("adresse"));
                maisonHotes.add(maisonHote);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maisonHotes;
    }

}
