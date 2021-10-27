/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import entities.Hebergement;
import entities.Reservation;
import entities.Voiture;
import java.date;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GestionReservationController implements Initializable {
    @FXML
    private TextField cin;
    @FXML
    private TextField datedeb;
    @FXML
    private TextField datefin;
     @FXML
    private TextField marque;
      @FXML
    private TextField adresse;
    @FXML
    private TableView<?> tvreservation;
    @FXML
    private Button ajouterR;
    @FXML
    private Button supprimeR;
    @FXML
    private Button modifierR;
    @FXML
    private Label nomComplet;
    @FXML
    private TableColumn<?, ?> colcin;
    @FXML
    private TableColumn<?, ?> coldatedeb;
    @FXML
    private TableColumn<?, ?> coldatefin;
    @FXML
    private TableColumn<?, ?> colmarque;
    @FXML
    private TableColumn<?, ?> coladresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectRowAction(MouseEvent event) {
    }

    @FXML
    private void ajouterReservation(ActionEvent event) {
    }

    @FXML
    private void supprimereservation(ActionEvent event) {
    }

    @FXML
    private void moudifierReservation(ActionEvent event) {
    }
    
}
