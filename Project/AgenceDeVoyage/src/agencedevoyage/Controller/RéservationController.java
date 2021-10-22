/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author HP
 */

public class RéservationController implements Initializable {

    @FXML
    private AnchorPane mychoiceBoxS;
    private String[] réservation ={"hebergement","voiture"};
    @FXML
    private ChoiceBox<?> mychooseBox;
    hoiceBox.getItems().add("voiture");
   choiceBox.getItems().add("hebergement");
    @FXML
    private Text idr;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label;
    @FXML
    private Text data_debut;
    @FXML
    private Text date_fin;
    @FXML
    private Label label4;
   
    
    
    
    

    @FXML
    private Label slect;
    @FXML
    private Button SupprimeRéservation;
    @FXML
    private Button MoudifierRéservation;
    
    @FXML
    private Button AjouterRéservationss;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
