/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Utilisateur;
import services.IService;
import database.DBConnection;
import entities.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bourg
 */
public class UtilisateurService implements IService<Utilisateur>{

    @Override
    public void ajouter(Utilisateur u) {
        String SQL = "INSERT INTO `utilisateur` (`nom`, `prenom`, `email`,`cin`,`passeport`,`login`, `mdp`) VALUES ("+"'" + u.getNom() + "', '" + u.getPrenom() + "', '" 
                + u.getEmail() + "','"+ u.getCin()+"','" + u.getPasseport() + "','" + u.getLogin()+ "','"+ u.getMdp() + "')";
        executeQuery(SQL);
    }

    @Override
    public boolean supprimer(Utilisateur u) {
         String SQL= "DELETE FROM `utilisateur` WHERE id="+u.getId();
         executeQuery(SQL);
         return true;

    }

    @Override
    public boolean modifier(Utilisateur u) {
        String SQL ="UPDATE `utilisateur` SET nom ='" +u.getNom()+"',prenom ='"+ u.getPrenom()+
                "',email ="+ u.getEmail()+"',cin ='"+u.getCin()+"',passeport='"+u.getPasseport()
                +",login='"+u.getLogin()+"',mdp='"+u.getMdp() +"' WHERE id ="+u.getId();
        executeQuery(SQL);   
        return true; }

    @Override
    public ObservableList<Utilisateur> consulter() {
        ObservableList<Utilisateur> utilisateurs =FXCollections.observableArrayList();
        Connection conn = DBConnection.getInstance().getConnection();
        String query ="SELECT * FROM `utilisateur`";
        Statement st;
        ResultSet rs;
        try{
            st =conn.createStatement();
            rs = st.executeQuery(query);
            Utilisateur utilisateur;
            while(rs.next()){
                utilisateur =new Utilisateur(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),
                rs.getString("cin"),rs.getString("passeport"),rs.getString("login"),rs.getString("mdp"));
                utilisateurs.add(utilisateur);
                
            }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return utilisateurs;
         
         
         }
    
}
