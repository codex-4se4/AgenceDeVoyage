/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.scene.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author HP
 */
public class myChoiceBox {

    public static class getIteams {

        public getIteams() {
        }
    }
    
}
public class RéservationController implements Initializable {
    @FXML
    private Label  mylabel;
    @FXML
    private ChoiceBox<String> mychoiseBox;
    private String[] réservation ={"hebergement","voiture"};
    myChoiceBox.getIteams().addAll("getréservation");
    myChoiceBox.setonAction(this::"getréservation");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}