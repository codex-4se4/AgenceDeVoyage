/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import agencedevoyage.AgenceDeVoyage;
import com.jfoenix.controls.JFXButton;
import entities.Utilisateur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    @FXML
    private Label mdpLabel;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
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
    private ImageView editer;
    @FXML
    private JFXButton sauvegarder;

    UtilisateurService utilisateurService;

    private int currentUserId;
    @FXML
    private Circle circle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurService = new UtilisateurService();

    }

    public void setUserInformation(Utilisateur u) throws FileNotFoundException {
        currentUserId = u.getId();
        nomComplet.setText(u.getPrenom() + " " + u.getNom());
        prenom.setText(u.getPrenom());
        nom.setText(u.getNom());
        email.setText(u.getEmail());
        cin.setText(u.getCin());
        passeport.setText(u.getPasseport());
        login.setText(u.getLogin());
        String imageUrl = "file:///"+ u.getPhoto().replace(" ", "/");
        Image img = new Image(imageUrl);
        circle.setFill(new ImagePattern(img));
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
                login.getText(), mdp.getText(), null);
        utilisateurService.modifier(user);
    }

    @FXML
    private void editerAction(MouseEvent event) {

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
}
