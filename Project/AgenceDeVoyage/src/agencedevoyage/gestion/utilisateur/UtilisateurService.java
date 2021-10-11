/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.gestion.utilisateur;

import agencedevoyage.IService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean supprimer(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> consulter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
