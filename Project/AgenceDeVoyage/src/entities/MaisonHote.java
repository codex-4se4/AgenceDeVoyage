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
public class MaisonHote extends Hebergement {

    private boolean avecPetitDejInclus;

    public MaisonHote() {
    }

    public MaisonHote(boolean avecPetitDejInclus, int id, int nbChambres, int nbPersonnes, boolean avecPiscine, boolean avecParking, boolean avecPlage, String adresse) {
        super(id, nbChambres, nbPersonnes, avecPiscine, avecParking, avecPlage, adresse);
        this.avecPetitDejInclus = avecPetitDejInclus;
    }

    public boolean isAvecPetitDejInclus() {
        return avecPetitDejInclus;
    }

    public void setAvecPetitDejInclus(boolean avecPetitDejInclus) {
        this.avecPetitDejInclus = avecPetitDejInclus;
    }

}
