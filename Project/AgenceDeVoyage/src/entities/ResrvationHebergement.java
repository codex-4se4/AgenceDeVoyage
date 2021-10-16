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
public class ResrvationHebergement {
    private int idh;
    private float prixh;
    private Date date_debutrh;
    private Date date_finrh;
    public  ResrvationHebergement(int idh,float prixh,Date date_debutrh,Date datefinrh){
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

    public Date getDate_debutrh() {
        return date_debutrh;
    }

    public void setDate_debutrh(Date date_debutrh) {
        this.date_debutrh = date_debutrh;
    }

    public Date getDate_finrh() {
        return date_finrh;
    }

    public void setDate_finrh(Date date_finrh) {
        this.date_finrh = date_finrh;
    }

   
    

    
}
