
package services;

import entities.ResrvationHebergement;


/**
 *
 * @author HP
 */
public  abstract class ReservationHebergementService implements IService<ResrvationHebergement>{
   
    @Override
    public void ajouter(ResrvationHebergement rh){
        String SQL = "INSERT INTO `ReservationHebergement` (`prixh`, `date_debutrh`, `date_finrh`) VALUES ("+"'" + rh.getPrixh()+ "', '" + rh.getDate_debutrh()+ "', '"
                + rh.getDate_finrh()+ "')";
        executeQuery(SQL);
    }
    @Override
    
    public boolean supprimer(ResrvationHebergement rh) {
    String SQL = "DELETE FROM 'ReservationHebergement' Where ID=" +rh.getIdh() ;
    executeQuery(SQL);
        return true;
    }
    @Override
   
   
    public boolean modifier(ResrvationHebergement rh) {
        String SQL = "UPDATE `ReservationHebergement` (`prixh`, `date_debutrh`, `date_finrh`) VALUES ("+"'" + rh.getPrixh()+ "', '" + rh.getDate_debutrh()+ "', '"
                + rh.getDate_finrh() + "')";
        
        executeQuery(SQL);
        return true;
   
    }
 
    public boolean consulter(ResrvationHebergement rh) {
    String SQL = "SELECT * FROM `ReservationHebergement` (`prixh`, `date_debutrh`, `date_finrh`) VALUES ("+"'" + rh.getPrixh() + "', '" + rh.getDate_debutrh() + "', '"
                + rh.getDate_finrh()+ "')";
    
        executeQuery(SQL);
        return true;
    }
}