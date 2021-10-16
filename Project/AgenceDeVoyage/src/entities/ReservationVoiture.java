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
public class ReservationVoiture {
    private int idv;
    private float prixv;
    private Date date_debutrv;
    private Date date_finrv;
    public ReservationVoiture(int idv,float prixv,Date date_debutrv,Date datefinrv){
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public float getPrixv() {
        return prixv;
    }

    public void setPrixv(float prixv) {
        this.prixv = prixv;
    }

    public Date getDate_debutrv() {
        return date_debutrv;
    }

    public void setDate_debutrv(Date date_debutrv) {
        this.date_debutrv = date_debutrv;
    }

    public Date getDate_finrv() {
        return date_finrv;
    }

    public void setDate_finrv(Date date_finrv) {
        this.date_finrv = date_finrv;
    }
    
    
    
    
    
    
    
    
}
