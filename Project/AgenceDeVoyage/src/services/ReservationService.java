package services;

import entities.Utilisateur;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entities.Reservation;
import entities.Hebergement;
import entities.Voiture;
import services.UtilisateurService;
import services.VoitureService;
import services.HebergementService;
import java.util.Date;
import java.sql.DataTruncation;

/**
 *
 * @author bourg
 */
public class ReservationService implements IService<Reservation> {

    
    @Override
    public void ajouter(Reservation r) {
        String SQL = "INSERT INTO `reservation` (`datedeb`,'datefin', `cin`,'marque','adresse','type' ,'prix') VALUES(" + "'" + r.getDatedeb() + "', '" + r.getDatefin() + "', '"
                + r.getUse().getCin()+ "','" + r.getVoi().getMarque() + "','" + r.getHeber().getAdresse() + "','" + r.getType() + "','" + r.getPrix() + "')";
        executeQuery(SQL);
        executeQuery(SQL);
        executeQuery(SQL);
    }
    

    @Override
    public boolean supprimer( Reservation r) {
        String SQL = "DELETE FROM `resevation` WHERE type=" + r.getType();
        executeQuery(SQL);
        return true;

    }

    @Override
    public boolean modifier(Reservation r) {
        String SQL = "UPDATE `utilisateur` SET datedeb ='" + r.getDatedeb()+ "', datefin ='" + r.getDatefin()
                + "',cin ='" + r.getUse().getCin()+ "',marque ='" + r.getVoi().getMarque()+ "',adresse='" + r.getHeber().getAdresse()
                + "',type='" + r.getType()+ "',prix='" + r.getPrix()+ "' WHERE type =" + r.getType();
        executeQuery(SQL);
        return true;
    }

    @Override
    public ObservableList<Reservation> consulter() {
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `rerservation`";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Reservation reservation;
            while (rs.next()) {
               reservation = new Reservation( rs.getDate("datedeb"), rs.getDate("datrfin"), rs.getString("cin"),
                        rs.getString("marque"), rs.getString("adresse"), rs.getString("type"), rs.getString("prix"));
                reservations.add(reservation);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reservations;

    }

  

}

