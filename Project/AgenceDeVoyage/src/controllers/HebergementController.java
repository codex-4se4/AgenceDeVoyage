/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import services.HebergementService;

/**
 * FXML Controller class
 *
 * @author Jawher-Louisa
 */
public class HebergementController implements Initializable {

   
    @FXML
    private TextField nbChambre;
    @FXML
    private TextField nbPersonne;
     @FXML
    private RadioButton Piscine;
    @FXML
    private RadioButton Parking;
    @FXML
    private RadioButton Plage;
     @FXML
    private TextField adresse;
     @FXML
    private Button btn;
     

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            
            HebergementService hs;
            try {
                hs = new HebergementService() {};
                hs.ajouter(new Hebergement(Integer.parseInt(nbChambre.getText()),Integer.parseInt(nbPersonne.getText()),Piscine.isSelected(),Parking.isSelected(),Plage.isSelected(),adresse.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(HebergementController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                btn.getScene().setRoot(FXMLLoader.load(getClass().getResource("FXMLaffiche.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(HebergementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
    
    }
}
