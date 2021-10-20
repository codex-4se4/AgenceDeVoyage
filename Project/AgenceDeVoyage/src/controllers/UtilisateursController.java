/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bourg
 */
public class UtilisateursController implements Initializable {

    @FXML
    private AnchorPane paneHolder;
    @FXML
    private Label nomComplet;
    @FXML
    private JFXButton editer;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField cin;
    @FXML
    private TextField passeport;
    @FXML
    private TextField login;
    @FXML
    private Label mdpLabel;
    @FXML
    private TextField mdp;
    @FXML
    private JFXButton sauvegarder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void editerAction(ActionEvent event) {
    }

    @FXML
    private void sauvegarderAction(ActionEvent event) {
    }

}
