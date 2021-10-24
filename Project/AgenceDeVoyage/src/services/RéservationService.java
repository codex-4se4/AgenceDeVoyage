
package services;

import database.DBConnection;
import entities.Réservation;
import static java.awt.event.PaintEvent.UPDATE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author HP
 */
public  class RéservationService implements IService<Réservation>{

    @Override
    public void ajouter(Réservation r) {
        String SQL = "INSERT INTO `réservation`(`id`, `idr`, `date_debut`, `date_fin`, `prix`, `type`)  VALUES ("+"'" + r.getprix() + "', '" + r.gettype() + "', '" 
                + r.getdate_debut() + "','"+ r.getdate_fin()+"','" + r.getidr() + "','" +  "')";
        executeQuery(SQL);
    }

    @Override
    public boolean supprimer(Réservation r) {
         String SQL= "DELETE FROM `utilisateur` WHERE id="+r.getId();
         executeQuery(SQL);
         return true;

    }

    @Override
    public boolean modifier(Réservation r) {String SQL =UPDATE `Réservation` SET idr ='" +r.getidr()+"',prix ='"+ r.getPrix()+ "',date_debut ="+ r.getdate_debut()+"',date_fin='"+r.getdate_fin()+"',type='"+r.gettype()
                +",' WHERE id ="+r.getId();
    executeQuery(SQL);
        return true; }

    @Override
    public ObservableList<Réservation> consulter() {
        ObservableList<Réservation> Réservation =FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query ="SELECT * FROM `Réservation`";
        Statement st;
        ResultSet rs;
        try{
            st =conn.createStatement();
            rs = st.executeQuery(query);
            Réservation réservation;
            while(rs.next()){
                Réservations =new Réservation(rs.getString("type"),rs.getDate("date_fin"),rs.getDate("date_debut"),               rs.getInt("idr"));
                Réservations.add(Réservation);
                
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return Réservations;
         
         
         }
    
}
