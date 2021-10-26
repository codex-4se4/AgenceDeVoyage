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
public class Offre {  

    public static void add(Offre offre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String type_Offre;
    private Date  debut_Offre;
    private Date fin_Offre;
    private float prix;
   
    
    public Offre(String type_offre,Date debut_offre,Date fin_Offre,float prix){
      
      this.type_Offre=type_Offre;
      this.debut_Offre=debut_Offre;
      this.fin_Offre=fin_Offre;
      this.prix=prix;
      
   }
    
    public Offre(){
        
    }

    public String getType_Offre() {
        return type_Offre;
    }

    public void setType_Offre(String type_Offre) {
        this.type_Offre = type_Offre;
    }

    public Date getDebut_Offre() {
        return debut_Offre;
    }

    public void setDebut_Offre(Date debut_Offre) {
        this.debut_Offre = debut_Offre;
    }

    public Date getFin_Offre() {
        return fin_Offre;
    }

    public void setFin_Offre(Date fin_Offre) {
        this.fin_Offre = fin_Offre;
    }


    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }



}


    

