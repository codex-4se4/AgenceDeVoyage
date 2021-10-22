/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Hebergement;
import services.IService;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Jawher-Louisa
 */
public abstract class HebergementService implements IService<Hebergement>{
    
    @Override
    public void ajouter(Hebergement h){
        String SQL = "INSERT INTO `hebergement` (`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("+"'" + h.getNbChambres() + "', '" + h.getNbPersonnes() + "', '" 
                + h.isAvecPiscine() + "','"+ h.isAvecParking()+"','" + h.isAvecPlage() + "','" + h.getAdresse()+ "')";
        executeQuery(SQL);
    }
    @Override
    public boolean supprimer(Hebergement h) {
    String SQL = "DELETE FROM 'hebergement' Where ID=" +h.getId() ;
    executeQuery(SQL);
        return true;
    }
    @Override
    
    
    public boolean modifier(Hebergement h) {
        String SQL = "UPDATE `hebergement` (`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("+"'" + h.getNbChambres() + "', '" + h.getNbPersonnes() + "', '" 
                + h.isAvecPiscine() + "','"+ h.isAvecParking()+"','" + h.isAvecPlage() + "','" + h.getAdresse()+ "')";
        executeQuery(SQL);
        return true;
    
    } 
 
    @Override
    public ObservableList<Hebergement> consulter() {
        ObservableList<Hebergement> hebergements =FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query ="SELECT * FROM hebergement";
        Statement st;
        ResultSet rs;
        try{
            st =conn.createStatement();
            rs = st.executeQuery(query);
            Hebergement hebergement;
            while(rs.next()){
                hebergement =new Hebergement(rs.getInt("nbChambres"),rs.getInt("nbPersonnes"),rs.getBoolean("avecPiscine"),
                rs.getBoolean("avecParking"),rs.getBoolean("avecPlage"),rs.getString("adresse"));
                hebergements.add(hebergement);
                
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return hebergements;
         
         
         }

    
}
