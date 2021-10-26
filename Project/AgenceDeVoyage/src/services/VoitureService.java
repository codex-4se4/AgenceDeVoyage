/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Voiture;

/**
 *
 * @author Ines Nfougui
 */

public abstract class VoitureService  implements IService<Voiture>{ 

    @Override
    public void ajouter(Voiture v) {
         String SQL = "INSERT INTO `voiture` (`marque`, `nbChevaux`, `type`) VALUES ("+"'" + v.getMarque() + "', '" + v.getNbChevaux() + "', '" + v.getTypevoiture() + "')";
         executeQuery(SQL);
    }

    @Override
    public boolean supprimer(Voiture v ) {
    String SQL = "DELETE FROM 'voiture' Where ID=" +v.getMatricule();
    executeQuery(SQL);
        return true;
    }

    @Override
    public boolean modifier(Voiture v) {
    String SQL = "UPDATE `voiture` (`marque`, `nbChevaux`, `type`) VALUES ("+"'" + v.getMarque() + "', '" + v.getNbChevaux() + "', '" + v.getTypevoiture() + "')";
         executeQuery(SQL);
           return true;
    }

    
    
    public boolean consulter(Voiture v) {
       String SQL = "SELECT * FROM `voiture` (`marque`, `nbChevaux`, `type`) VALUES ("+"'" + v.getMarque() + "', '" + v.getNbChevaux() + "', '" + v.getTypevoiture() + "')";
         executeQuery(SQL);
           return true;
    }

}