/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Jawher-Louisa
 */
public class Hebergement {
    
      private int id;
      private  int nbChambres;
      private  int nbPersonnes;
      private  boolean avecPiscine;
      private  boolean avecParking;
      private  boolean avecPlage;
      private  String adresse;
      
      
      public Hebergement(int nbChambres, int nbPersonnes, boolean avecPiscine, boolean avecParking, boolean avecPlage, String adresse ) {
        this.nbChambres = nbChambres;
        this.nbPersonnes = nbPersonnes;
        this.avecPiscine = avecPiscine;
        this.avecParking = avecParking;
        this.avecPlage = avecPlage;
        this.adresse = adresse;
      }
    public Hebergement(){
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbChambres() {
        return nbChambres;
    }

    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public boolean isAvecPiscine() {
        return avecPiscine;
    }

    public void setAvecPiscine(boolean avecPiscine) {
        this.avecPiscine = avecPiscine;
    }

    public boolean isAvecParking() {
        return avecParking;
    }

    public void setAvecParking(boolean avecParking) {
        this.avecParking = avecParking;
    }

    public boolean isAvecPlage() {
        return avecPlage;
    }

    public void setAvecPlage(boolean avecPlage) {
        this.avecPlage = avecPlage;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    void add(Hebergement hebergement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    
}

