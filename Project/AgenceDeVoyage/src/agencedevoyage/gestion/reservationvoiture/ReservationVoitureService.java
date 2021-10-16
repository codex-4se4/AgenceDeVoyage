package agencedevoyage.gestion.reservationvoiture;
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
public abstract class ReservationVoitureService implements IService<ReservationVoiture>{
   
    @Override
    public void ajouter(ReservationVoiture rv){
        String SQL = "INSERT INTO `ReservationVoiture` (`prixv`, `date_debutrv`, `date_finrv`) VALUES ("+"'" + rv.getprixv() + "', '" + rv.getdate_debutrv() + "', '"
                + rv.getdate_finrv() + "')";
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
        String SQL = "UPDATE `ReservationVoiture` (`prixv`, `date_debutrv`, `date_finrv`) VALUES ("+"'" + rv.getprixv() + "', '" + rv.getdate_debutrv() + "', '"
                + rv.getdate_finrv() + "')";
        
        executeQuery(SQL);
        return true;
   
    }
 
    public boolean consulter(ReservationVoiture rv) {
    String SQL = "SELECT * FROM `ReservationVoiture` (`prixv`, `date_debutrv`, `date_finrv`) VALUES ("+"'" + rv.getprixv() + "', '" + rv.getdate_debutrv() + "', '"
                + rv.getdate_finrv() + "')";
    
        executeQuery(SQL);
        return true;
    }
}
