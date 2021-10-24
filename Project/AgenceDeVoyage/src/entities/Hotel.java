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
public class Hotel extends Hebergement {

    private int nbEtoiles;
    private String formule;
    private String typeChambre;

    public Hotel(int nbEtoiles, String formule, String typeChambre, int id, int nbChambres, int nbPersonnes, boolean avecPiscine, boolean avecParking, boolean avecPlage, String adresse) {
        this.nbEtoiles = nbEtoiles;
        this.formule = formule;
        this.typeChambre = typeChambre;
    }

    public Hotel(int nbEtoiles, String formule, String typeChambre) {
        this.nbEtoiles = nbEtoiles;
        this.formule = formule;
        this.typeChambre = typeChambre;
    }

    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public void setNbEtoiles(int nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

}
