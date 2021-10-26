/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.Partenariatservice;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PartenariatController implements Initializable {
   @FXML
    private Button ajouter;

    @FXML
    private Text ContratFin;

    @FXML
    private Button supprimer;

    @FXML
    private Text ContratDebut;

    @FXML
    private Button modifier;

    @FXML
    private TextField name;

    @FXML
    private Text adresse;

    @FXML
    private TextField adress;

    @FXML
    private DatePicker Fin;

    @FXML
    private Text nom;

    @FXML
    private DatePicker Debut;
    
    

/**private Partenariatservice partenariatservice
     * @param event;*/

    
     public void getDate(ActionEvent event){
        LocalDate myDate = Debut.getValue();
                System.out.println(myDate.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           name.setStyle("-fx-text-inner-color: #a0a2ab ;");
           adresse.setStyle("-fx-text-inner-color: #a0a2ab;");


           
           
           
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
   
        
    }
