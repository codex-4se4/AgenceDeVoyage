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
    private Date  date;
    private String type;
  
     public Reservation() {
    }
    public  Reservation( String type,Hebergement heber, Voiture voi,Utilisateur use,Date  date ){
    this.type=type;
    this.voi = voi;
    this.use=use;
    this.date=date;
   
    
}
     public  Reservation(Hebergement heber, Voiture voi,Utilisateur use,Date  date){
    
    this.heber= heber;
    this.voi = voi;
    this.use=use;
    this.date=date;
     }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   

   
   
}
