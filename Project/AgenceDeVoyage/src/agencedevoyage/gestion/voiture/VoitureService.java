/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.gestion.voiture;
import agencedevoyage.IService;
import agencedevoyage.configuration.database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ines Nfougui
 */

public abstract class VoitureService  implements IService<voiture>{ 

    @Override
    public void ajouter(voiture v) {
         String SQL = "INSERT INTO `voiture` (`marque`, `nbChevaux`, `type`) VALUES ("+"'" + v.getMarque() + "', '" + v.getNbChevaux() + "', '" + v.getTypevoiture() + "')";
         executeQuery(SQL);
    }

    @Override
    public boolean supprimer(voiture v ) {
    String SQL = "DELETE FROM 'voiture' Where ID=" +v.getMatricule();
    executeQuery(SQL);
        return true;
    }

    @Override
    public boolean modifier(voiture v) {
    String SQL = "UPDATE `voiture` (`marque`, `nbChevaux`, `type`) VALUES ("+"'" + v.getMarque() + "', '" + v.getNbChevaux() + "', '" + v.getTypevoiture() + "')";
         executeQuery(SQL);
           return true;
    }

    
    
    public boolean consulter(voiture v) {
       String SQL = "SELECT * FROM `voiture` (`marque`, `nbChevaux`, `type`) VALUES ("+"'" + v.getMarque() + "', '" + v.getNbChevaux() + "', '" + v.getTypevoiture() + "')";
         executeQuery(SQL);
           return true;
    }

}