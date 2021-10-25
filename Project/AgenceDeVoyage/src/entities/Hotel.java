/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;

/**
 *
 * @author Jawher-Louisa
 */
public class Hotel extends Hebergement {

    private int nbEtoiles;

    
    public Hotel(int nbEtoiles, int id, int nbChambres, int nbPersonnes, boolean avecPiscine, boolean avecParking, boolean avecPlage, String adresse) {
        super(id, nbChambres, nbPersonnes, avecPiscine, avecParking, avecPlage, adresse);
        this.nbEtoiles = nbEtoiles;
    }

    public Hotel() {
    }

    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public void setNbEtoiles(int nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

}
