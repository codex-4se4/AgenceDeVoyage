/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PartenariatController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField adress;
    @FXML
    private TextField idd;
    @FXML
    private Text nom;
    @FXML
    private Text adresse;
    @FXML
    private Text id;
    @FXML
    private Text ContratDebut;
    @FXML
    private Text ContratFin;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private DatePicker Debut;
    @FXML
    private DatePicker Fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
