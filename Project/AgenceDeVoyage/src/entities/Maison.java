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
public class Maison extends Hebergement {

    private float surfaceJardin;

    public Maison() {
    }

    public Maison(float surfaceJardin, int id, int nbChambres, int nbPersonnes, boolean avecPiscine, boolean avecParking, boolean avecPlage, String adresse) {
        super(id, nbChambres, nbPersonnes, avecPiscine, avecParking, avecPlage, adresse);
        this.surfaceJardin = surfaceJardin;
    }

    public float getSurfaceJardin() {
        return surfaceJardin;
    }

    public void setSurfaceJardin(float surfaceJardin) {
        this.surfaceJardin = surfaceJardin;
    }

}
