/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DBConnection;
import entities.Partenariat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author HP
 */
public abstract class Partenariatservice implements IService <Partenariat>{
    @Override
    public void ajouter(Partenariat p){
        String SQL = "INSERT INTO `partenariat` (`id`, `nom`, `adresse`,`ContratDebut`,`ContratFin`) VALUES ("+"'" + p.getId() + "', '" + p.getNom() + "', '"
                + p.getAdresse() + "','"+ p.getContratDebut()+"','" + p.getContratFin() + "')";
        executeQuery(SQL);
    }
       
    @Override
    public boolean supprimer(Partenariat p) {
    String SQL = "DELETE FROM 'partenariat' Where ID=" +p.getId() ;
    executeQuery(SQL);
        return true;
    }
    public boolean modifier(Partenariat p) {
        String SQL = "UPDATE `partenariat`  (`id`, `nom`, `adresse`,`ContratDebut`,`ContratFin`) VALUES ("+"'" + p.getId() + "', '" + p.getNom() + "', '"
                + p.getAdresse() + "','"+ p.getContratDebut()+"','" + p.getContratFin() + "')";
        executeQuery(SQL);
        return false;
    }
 
   @Override
    public ObservableList<Partenariat> consulter() {
        ObservableList<Partenariat> utilisateurs = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `utilisateur`";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
           Partenariat partenariat;
            while (rs.next()) {
                Partenariat Partenariat = new Partenariat(rs.getInt("id"), rs.getString("nom"), rs.getString("adresse"), rs.getDate("ContratDebut"),
                        rs.getDate("ContratFin"));
                Partenariat.add(Partenariat);
                
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ObservableList<Partenariat> Partenariat = null;
        return Partenariat;
        
    }
    
}
