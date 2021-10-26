/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;


public class Reservation {
    private int id;
    private  int idr;
    private double prix;
    private Date date_debut;
    private Date date_fin;
    private String type;
     public Reservation() {
    }
    public  Reservation(int id, int idr ,double prix,Date date_debutr,Date datefinrh,String type){
    this.prix= prix;
    this.date_debut = date_debut;
    this.date_fin=date_fin;
    this.type=type;
    this.idr=idr;
    
}
     public  Reservation(double prix,Date date_debutr,Date datefinrh,int idr,String type){
    this.prix= prix;
    this.date_debut = date_debut;
    this.date_fin=date_fin;
    this.type=type;
    this.idr=idr;
    
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
}
