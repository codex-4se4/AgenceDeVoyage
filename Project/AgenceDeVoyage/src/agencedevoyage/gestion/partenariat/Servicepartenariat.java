/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencevoyage.gestion.partenariat;

import agencedevoyage.IService;

/**
 *
 * @author HP
 */
public abstract class Servicepartenariat implements IService <partenariat>{
    @Override
    public void ajouter(partenariat p){
        String SQL = "INSERT INTO `partenariat` (`id`, `nom`, `adresse`,`ContratDebut`,`ContratFin`) VALUES ("+"'" + p.getId() + "', '" + p.getNom() + "', '"
                + p.getAdresse() + "','"+ p.getContratDebut()+"','" + p.getContratFin() + "')";
        executeQuery(SQL);
    }
       
    @Override
    public boolean supprimer(partenariat p) {
    String SQL = "DELETE FROM 'partenariat' Where ID=" +p.getId() ;
    executeQuery(SQL);
        return true;
    }
    public boolean modifier(partenariat p) {
        String SQL = "UPDATE `partenariat`  (`id`, `nom`, `adresse`,`ContratDebut`,`ContratFin`) VALUES ("+"'" + p.getId() + "', '" + p.getNom() + "', '"
                + p.getAdresse() + "','"+ p.getContratDebut()+"','" + p.getContratFin() + "')";
        executeQuery(SQL);
        return false;
    }
 
    public boolean consulter(partenariat p) {
    String SQL = "SELECT * FROM `partenariat` (`id`, `nom`, `adresse`,`ContratDebut`,`ContratFin`) VALUES ("+"'" + p.getId() + "', '" + p.getNom() + "', '"
                + p.getAdresse() + "','"+ p.getContratDebut()+"','" + p.getContratFin() + "')";
        executeQuery(SQL);
        return true;
    }
}
