/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import database.DBConnection;
import entities.Offre;
import entities.Partenariat;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.INSERT;
import static javax.management.Query.value;
import static javax.management.Query.value;


/**
 *
 * @author HP
 */

    public abstract class Offreservice implements IService <Offre>{
    public void ajouter(Offre O){
     String SQL;
        SQL = "INSERT INTO `offre`(`type_Offre`, `debut_Offre`, `fin_Offre`, `prix`) VALUES ([value-1],[value-2],[value-3],[value-4])";
     executeQuery(SQL);
    }
    
    @Override
    public boolean supprimer(Offre O) {
        String SQL;
        SQL = "DELETE FROM `offre` WHERE type_Offre="+O.getType_Offre();
        executeQuery(SQL);
        return true;
    }
   
        
        
        
        
    @Override
     public boolean modifier(Offre O) {
        String SQL =" UPDATE `offre` SET `type_Offre`=[value-1],`debut_Offre`=[value-2],`fin_Offre`=[value-3],`prix`=[value-4] WHERE type_Offre="+O.getType_Offre();
        executeQuery(SQL);
        return true;
    }
    
     
     
      @Override
    public ObservableList<Offre> consulter() {
        ObservableList<Offre> offres;
        offres = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `offre`";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
           Offre offre;
            while (rs.next()) {
                offre = new Offre (rs.getString("type_Offre"), rs.getDate("debut_Offre"), rs.getDate("fin_Offre"), rs.getFloat("prix"));
                Offre.add(offre);
                
            }
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ObservableList<Offre> offre = null;
        return offre ;
        
    }
     
    }
