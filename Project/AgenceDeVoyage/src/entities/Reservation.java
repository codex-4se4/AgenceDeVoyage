/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;


public class Reservation {
    private  Hebergement heber;
    private  Voiture voi ;
   private Utilisateur use;
    private Date  datedeb;
    private Date datefin;
    private String prix;
    private String type;
    
  
     public Reservation() {
    }
    public  Reservation(Hebergement heber, Voiture voi,Utilisateur use,Date datedeb,Date datefin ){
    this.heber=heber;
    this.voi = voi;
    this.use=use;
    this.datedeb=datedeb;
    this.datefin=datefin;
    this.prix=prix;
   this.type=type;
    
}

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    

    public Hebergement getHeber() {
        return heber;
    }

    public void setHeber(Hebergement heber) {
        this.heber = heber;
    }

    public Voiture getVoi() {
        return voi;
    }

    public void setVoi(Voiture voi) {
        this.voi = voi;
    }

    public Utilisateur getUse() {
        return use;
    }

    public void setUse(Utilisateur use) {
        this.use = use;
    }

    public Date getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(Date datedeb) {
        this.datedeb = datedeb;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}