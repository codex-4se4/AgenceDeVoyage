
package agencedevoyage.gestion.reservationhebergement;
import agencedevoyage.IService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author HP
 */
public  abstract class ReservationHebergementService implements IService<ResrvationHebergement>{
   
    @Override
    public void ajouter(ResrvationHebergement rh){
        String SQL = "INSERT INTO `ReservationHebergement` (`prixh`, `date_debutrh`, `date_finrh`) VALUES ("+"'" + rh.getprixh() + "', '" + rh.getdate_debutrh() + "', '"
                + rh.getdate_finrh() + "')";
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
        String SQL = "UPDATE `ReservationHebergement` (`prixh`, `date_debutrh`, `date_finrh`) VALUES ("+"'" + rh.getprixh() + "', '" + rh.getdate_debutrh() + "', '"
                + rh.getdate_finrh() + "')";
        
        executeQuery(SQL);
        return true;
   
    }
 
    public boolean consulter(ResrvationHebergement rh) {
    String SQL = "SELECT * FROM `ReservationHebergement` (`prixh`, `date_debutrh`, `date_finrh`) VALUES ("+"'" + rh.getprixh() + "', '" + rh.getdate_debutrh() + "', '"
                + rh.getdate_finrh() + "')";
    
        executeQuery(SQL);
        return true;
    }
}