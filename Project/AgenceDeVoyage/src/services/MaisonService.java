/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DBConnection;
import entities.Maison;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jawher-Louisa
 */
public class MaisonService implements IService<Maison> {

    @Override
    public void ajouter(Maison m) {
        String SQL1 = "INSERT INTO `hebergement` (`id`,`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("
                + m.getId() + "," + m.getNbChambres() + "," + m.getNbPersonnes() + "," + m.isAvecPiscine() + "," + m.isAvecParking() + "," + m.isAvecPlage() + ", '" + m.getAdresse() + "')";
        executeQuery(SQL1);
        String SQL2 = "INSERT INTO `maison` (`id`,`surfaceJardin`) VALUES ("
                + m.getId() + " , " + m.getSurfaceJardin() + ")";
        executeQuery(SQL2);
    }

    @Override
    public boolean supprimer(Maison m) {
        String SQL1 = "DELETE FROM `maison` WHERE id=" + m.getId();
        executeQuery(SQL1);
        String SQL2 = "DELETE FROM `hebergement` WHERE id=" + m.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public boolean modifier(Maison m) {
        String SQL1 = "UPDATE `hebergement` SET nbChambres =" + m.getNbChambres() + ", nbPersonnes =" + m.getNbPersonnes()
                + ",avecPiscine =" + m.isAvecPiscine() + ",avecParking =" + m.isAvecParking() + ",avecPlage=" + m.isAvecPlage()
                + ",adresse='" + m.getAdresse() + "' WHERE id =" + m.getId();
        executeQuery(SQL1);
        String SQL2 = "UPDATE `maison` SET surfaceJardin =" + m.getSurfaceJardin()
                + " WHERE id =" + m.getId();
        executeQuery(SQL2);
        return true;
    }

    @Override
    public ObservableList<Maison> consulter() {
        ObservableList<Maison> maisons = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM maison m inner join hebergement h on h.id = m.id";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Maison maison;
            while (rs.next()) {
                maison = new Maison(rs.getFloat("surfaceJardin"), rs.getInt("id"), rs.getInt("nbChambres"), rs.getInt("nbPersonnes"), rs.getBoolean("avecPiscine"),
                        rs.getBoolean("avecParking"), rs.getBoolean("avecPlage"), rs.getString("adresse"));
                maisons.add(maison);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maisons;
    }

}
