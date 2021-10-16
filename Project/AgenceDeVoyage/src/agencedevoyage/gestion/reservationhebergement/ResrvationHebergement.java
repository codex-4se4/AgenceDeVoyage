/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agancedevoyage.gestion.reservationhebergement;

import java.date;

/**
 *
 * @author HP
 */
public class ResrvationHebergement {
    private int idh;
    private float prixh;
    private date date_debutrh;
    private date date_finrh;
    public  ResrvationHebergement(int idh,float prixh,date date_debutrh,date datefinrh){
    this.prixh = prixh;
    this.date_debutrh = date_debutrh;
    this.date_finrh = date_finrh;
    
}

    public int getIdh() {
        return idh;
    }

    public void setIdh(int idh) {
        this.idh = idh;
    }

    public float getPrixh() {
        return prixh;
    }

    public void setPrixh(float prixh) {
        this.prixh = prixh;
    }

    public date getDate_debutrh() {
        return date_debutrh;
    }

    public void setDate_debutrh(date date_debutrh) {
        this.date_debutrh = date_debutrh;
    }

    public date getDate_finrh() {
        return date_finrh;
    }

    public void setDate_finrh(date date_finrh) {
        this.date_finrh = date_finrh;
    }

   
    

    
}
