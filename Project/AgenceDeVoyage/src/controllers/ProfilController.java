/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import agencedevoyage.AgenceDeVoyage;
import com.jfoenix.controls.JFXButton;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author bourg
 */
public class ProfilController implements Initializable {

    @FXML
    private AnchorPane paneHolder;
    @FXML
    private Label nomComplet;
    private TextField prenomLabel;
    private TextField nomLabel;
    private TextField emailLabel;
    private TextField passeportLabel;
    private TextField loginLabel;
    private TextField cinLabel;
    @FXML
    private Label mdpLabel;
    @FXML
    private TextField prenom;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @
    @FXML
    private TextField email;
    @FXML
    private TextField passeport;
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;
    @FXML
    private TextField cin;
    @FXML
    private JFXButton editer;
    @FXML
    private JFXButton sauvegarder;

    UtilisateurService utilisateurService;

    private int currentUserId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurService = new UtilisateurService();

    }

    public void setUserInformation(Utilisateur u) {
        currentUserId = u.getId();
        nomComplet.setText(u.getPrenom() + " " + u.getNom());
        prenom.setText(u.getPrenom());
        nom.setText(u.getNom());
        email.setText(u.getEmail());
        cin.setText(u.getCin());
        passeport.setText(u.getPasseport());
        login.setText(u.getLogin());
    }

    @FXML
    private void editerAction(ActionEvent event) {
        prenom.setEditable(true);
        nom.setEditable(true);
        email.setEditable(true);
        cin.setEditable(true);
        passeport.setEditable(true);
        login.setEditable(true);
        editer.setVisible(false);
        sauvegarder.setVisible(true);
        mdp.setVisible(true);
        mdp.setEditable(true);
        mdpLabel.setVisible(true);

    }

    @FXML
    private void sauvegarderAction(ActionEvent event) {
        prenom.setEditable(false);
        nom.setEditable(false);
        email.setEditable(false);
        cin.setEditable(false);
        passeport.setEditable(false);
        login.setEditable(false);
        editer.setVisible(true);
        sauvegarder.setVisible(false);
        mdp.setVisible(false);
        mdp.setEditable(false);
        mdpLabel.setVisible(false);
        Utilisateur user = new Utilisateur(currentUserId, nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(),
                login.getText(), mdp.getText());
        utilisateurService.modifier(user);
    }
}
