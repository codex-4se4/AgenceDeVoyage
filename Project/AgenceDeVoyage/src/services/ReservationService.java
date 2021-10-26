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

/**
 *
 * @author bourg
 */
public class ReservationService implements IService<Reservation> {

    
    @Override
    public void ajouter(Reservation r) {
        String SQL = "INSERT INTO `reservation` (`type`, `date`, ``,`nom`, `prenom`,) VALUES (" + "'" + r.getType()+ "', '" + r.getDate()+ r.get()+ "', '" + r.getDate()+ "')";
        executeQuery(SQL);
    }
    @Override
    public void ajouter(Utilisateur u) {
        String SQL = "INSERT INTO `utilisateur` (`nom`, `prenom`) VALUES (" + "'" + u.getNom() + "', '" + u.getPrenom()  + "')";
        executeQuery(SQL);
    }

    @Override
    public boolean supprimer(Utilisateur u) {
        String SQL = "DELETE FROM `utilisateur` WHERE id=" + u.getId();
        executeQuery(SQL);
        return true;

    }

    @Override
    public boolean modifier(Utilisateur u) {
        String SQL = "UPDATE `utilisateur` SET nom ='" + u.getNom() + "', prenom ='" + u.getPrenom()
                + "',email ='" + u.getEmail() + "',cin ='" + u.getCin() + "',passeport='" + u.getPasseport()
                + "',login='" + u.getLogin() + "',mdp='" + u.getMdp() + "' WHERE id =" + u.getId();
        executeQuery(SQL);
        return true;
    }

    @Override
    public ObservableList<Utilisateur> consulter() {
        ObservableList<Utilisateur> utilisateurs = FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `utilisateur`";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Utilisateur utilisateur;
            while (rs.next()) {
                utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
                        rs.getString("cin"), rs.getString("passeport"), rs.getString("login"), rs.getString("mdp"));
                utilisateurs.add(utilisateur);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return utilisateurs;

    }

    public Utilisateur consulterParEmail(String email) {
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM `utilisateur` where email = '" + email + "'";
        Statement st;
        ResultSet rs;
        Utilisateur utilisateur = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            utilisateur = new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
                    rs.getString("cin"), rs.getString("passeport"), rs.getString("login"), rs.getString("mdp"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return utilisateur;

    }

}
