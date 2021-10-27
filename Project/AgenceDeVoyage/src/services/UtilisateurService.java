/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Utilisateur;
import database.DBConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bourg
 */
public class UtilisateurService implements IService<Utilisateur> {

    @Override
    public void ajouter(Utilisateur u) {
        u.setPhoto(u.getPhoto().replace("\\", " "));
        String SQL = "INSERT INTO `utilisateur` (`nom`, `prenom`, `email`,`cin`,`passeport`,`login`, `mdp`,`photo`) VALUES (" + "'" + u.getNom() + "', '" + u.getPrenom() + "', '"
                + u.getEmail() + "','" + u.getCin() + "','" + u.getPasseport() + "','" + u.getLogin() + "','" + u.getMdp() + "','" + u.getPhoto() + "')";
        executeQuery(SQL);
    }

    @Override
    public boolean supprimer(Utilisateur u) {
        String SQL = "DELETE FROM `utilisateur` WHERE id=" + u.getId();
        executeQuery(SQL);
        return true;

    }

    @Override
    public boolean modifier(Utilisateur u) {
        String SQL = "UPDATE `utilisateur` SET nom ='" + u.getNom() + "', prenom ='" + u.getPrenom()
                + "',email ='" + u.getEmail() + "',cin ='" + u.getCin() + "',passeport='" + u.getPasseport()
                + "',login='" + u.getLogin() + "',mdp='" + u.getMdp() + "' WHERE id =" + u.getId();
        executeQuery(SQL);
        return true;
    }

    @Override
    public ObservableList<Utilisateur> consulter() {
        ObservableList<Utilisateur> utilisateurs = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `utilisateur`";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Utilisateur utilisateur;
            while (rs.next()) {
                utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
                        rs.getString("cin"), rs.getString("passeport"), rs.getString("login"), rs.getString("mdp"),rs.getString("photo"));
                utilisateurs.add(utilisateur);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return utilisateurs;

    }

    public Utilisateur consulterParEmail(String email) {
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `utilisateur` where email = '" + email + "'";
        Statement st;
        ResultSet rs;
        Utilisateur utilisateur = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
                    rs.getString("cin"), rs.getString("passeport"), rs.getString("login"), rs.getString("mdp"),rs.getString("photo"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return utilisateur;

    }

}
