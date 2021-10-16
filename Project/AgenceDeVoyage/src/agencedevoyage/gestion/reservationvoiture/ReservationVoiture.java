/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.gestion.reservationvoiture;
import java.date;
/**
 *
 * @author HP
 */
public class ReservationVoiture {
    private int idv;
    private float prixv;
    private date date_debutrv;
    private date date_finrv;
    public ReservationVoiture(float prixv,date date_debutrv,date datefinrv){
    
    this.prixv = prixv;
    this.date_debutrv = date_debutrv;
    this.date_finrv = date_finrv;
    
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

    public date getDate_debutrv() {
        return date_debutrv;
    }

    public void setDate_debutrv(date date_debutrv) {
        this.date_debutrv = date_debutrv;
    }

    public date getDate_finrv() {
        return date_finrv;
    }

    public void setDate_finrv(date date_finrv) {
        this.date_finrv = date_finrv;
    }

    String getprixv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getdate_finrv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getdate_debutrv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
