/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.gestion.utilisateur;

import agencedevoyage.IService;
<<<<<<< Updated upstream
=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;

/**
 *
 * @author bourg
 */
<<<<<<< Updated upstream
public class UtilisateurService implements IService<Utilisateur>{

    @Override
    public void ajouter(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
=======
public class UtilisateurService {

   /* @Override
    public void ajouter(Utilisateur u){

    String query = "INSERT INTO `utilisateur` (`nom`, `prenom`, `login`, `mdp`, `passeport`) VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getAge() + "');";
    executeQuery(query);
        }



    @Override
    public boolean supprimer(Utilisateur u) {
    }

    @Override
    public boolean modifier(Utilisateur u){
    }

    @Override
    public List<Utilisateur> consulter(){

    }
*/
>>>>>>> Stashed changes

    
}
