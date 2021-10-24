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
public class Appartement extends Hebergement {
    
    private int numeroEtage;

    private boolean avecAscenseur;

    public Appartement() {
    }

    public Appartement(int numeroEtage, boolean avecAscenseur, int id, int nbChambres, int nbPersonnes, boolean avecPiscine, boolean avecParking, boolean avecPlage, String adresse) {
        super(id, nbChambres, nbPersonnes, avecPiscine, avecParking, avecPlage, adresse);
        this.numeroEtage = numeroEtage;
        this.avecAscenseur = avecAscenseur;
    }

    public int getNumeroEtage() {
        return numeroEtage;
    }

    public void setNumeroEtage(int numeroEtage) {
        this.numeroEtage = numeroEtage;
    }

    public boolean isAvecAscenseur() {
        return avecAscenseur;
    }

    public void setAvecAscenseur(boolean avecAscenseur) {
        this.avecAscenseur = avecAscenseur;
    }

}
