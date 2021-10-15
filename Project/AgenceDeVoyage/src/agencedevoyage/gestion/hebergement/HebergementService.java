/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.gestion.hebergement;

import agencedevoyage.IService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

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
 
    public boolean consulter(Hebergement h) {
    String SQL = "SELECT * FROM `hebergement` (`nbChambres`, `nbPersonnes`, `avecPiscine`,`avecParking`,`avecPlage`,`adresse`) VALUES ("+"'" + h.getNbChambres() + "', '" + h.getNbPersonnes() + "', '" 
                + h.isAvecPiscine() + "','"+ h.isAvecParking()+"','" + h.isAvecPlage() + "','" + h.getAdresse()+ "')";
        executeQuery(SQL);
        return true; 
    }


    
}
