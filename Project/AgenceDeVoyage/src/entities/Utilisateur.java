/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author bourg
 */
public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String cin;
    private String passeport;
    private String login;
    private String mdp;
    private String photo;

    public Utilisateur(int id, String nom, String prenom, String email, String cin, String passeport, String login, String mdp, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.passeport = passeport;
        this.login = login;
        this.mdp = DigestUtils.shaHex(mdp);
        this.photo = photo;
    }

    public Utilisateur(String nom, String prenom, String email, String cin, String passeport, String login, String mdp, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.passeport = passeport;
        this.login = login;
        this.mdp = DigestUtils.shaHex(mdp);
        this.photo = photo;
    }

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = DigestUtils.shaHex(mdp);
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
