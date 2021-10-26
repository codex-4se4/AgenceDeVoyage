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
import entities.Voiture;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GestionReservationController implements Initializable {
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField idH;
    @FXML
    private TextField marqueV;
    @FXML
    private TableView<?> tvreservation;
    @FXML
    private TableColumn<Utilisateur, String> colprenom;
    @FXML
    private TableColumn<Utilisateur, String> colnom;
    @FXML
    private TableColumn<Hebergement,Int> colidhebergement;
    @FXML
    private TableColumn<?, ?> colmarquevoiture;
    @FXML
    private TableColumn<?, ?> coldate;
    @FXML
    private Button ajouterR;
    @FXML
    private Button supprimeR;
    @FXML
    private Button modifierR;
    @FXML
    private TextField dateR;

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
    
}
