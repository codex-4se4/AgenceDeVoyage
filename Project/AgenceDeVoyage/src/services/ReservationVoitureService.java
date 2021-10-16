package services;

import entities.ReservationVoiture;


/**
 *
 * @author HP
 */
public abstract class ReservationVoitureService implements IService<ReservationVoiture>{
   
    @Override
    public void ajouter(ReservationVoiture rv){
        String SQL = "INSERT INTO `ReservationVoiture` (`prixv`, `date_debutrv`, `date_finrv`) VALUES ("+"'" + rv.getPrixv()+ "', '" + rv.getDate_debutrv()+ "', '"
                + rv.getDate_finrv()+ "')";
        executeQuery(SQL);
    }
    @Override
    public boolean supprimer(ReservationVoiture rv) {
    String SQL = "DELETE FROM 'ReservationVoiture' Where ID=" +rv.getIdv() ;
    executeQuery(SQL);
        return true;
    }
    @Override
   
   
    public boolean modifier(ReservationVoiture rv) {
        String SQL = "UPDATE `ReservationVoiture` (`prixv`, `date_debutrv`, `date_finrv`) VALUES ("+"'" + rv.getPrixv()+ "', '" + rv.getDate_debutrv()+ "', '"
                + rv.getDate_finrv()+ "')";
        
        executeQuery(SQL);
        return true;
   
    }
 
    public boolean consulter(ReservationVoiture rv) {
    String SQL = "SELECT * FROM `ReservationVoiture` (`prixv`, `date_debutrv`, `date_finrv`) VALUES ("+"'" + rv.getPrixv()+ "', '" + rv.getDate_debutrv()+ "', '"
                + rv.getDate_finrv()+ "')";
    
        executeQuery(SQL);
        return true;
    }
}
