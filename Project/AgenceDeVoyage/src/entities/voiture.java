/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ines Nfougui
 */
public class voiture {
        private int matricule;
    private String marque;
    private int nbChevaux;
    private typevoiture  typevoiture;

   

    public voiture(int matricule, String marque, int nbChevaux, typevoiture typevoiture) {
        this.matricule = matricule;
        this.marque = marque;
        this.nbChevaux = nbChevaux;
        this.typevoiture = typevoiture;
    }




    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbChevaux() {
        return nbChevaux;
    }

    public void setNbChevaux(int nbChevaux) {
        this.nbChevaux = nbChevaux;
    }
        public typevoiture getTypevoiture() {
        return typevoiture;
    }

    public void setTypevoiture(typevoiture typevoiture) {
        this.typevoiture = typevoiture;
    }

    @Override
    public String toString() {
        return "voiture{" + "matricule=" + matricule + ", marque=" + marque + ", nbChevaux=" + nbChevaux + ", typevoiture=" + typevoiture + '}';

    
}
}