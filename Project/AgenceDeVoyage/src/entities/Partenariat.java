/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Partenariat {
    private int id;
    private String nom;
    private String adresse;
    private Date ContratDebut;
    private Date ContratFin;
    
    public Partenariat(int id,String nom,String adresse,Date ContratDebut,Date ContratFin){
      this.id=id;
      this.nom=nom;
      this.adresse=adresse;
      this.ContratDebut=ContratDebut;
      this.ContratFin=ContratFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getContratDebut() {
        return ContratDebut;
    }

    public void setContratDebut(Date ContratDebut) {
        this.ContratDebut = ContratDebut;
    }

    public Date getContratFin() {
        return ContratFin;
    }

    public void setContratFin(Date ContratFin) {
        this.ContratFin = ContratFin;
    }

    public void add(Partenariat partenariat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
