/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
<<<<<<< Updated upstream
import javafx.fxml.FXML;
=======
>>>>>>> Stashed changes
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author bourg
 */
public class MainController implements Initializable {
    
<<<<<<< Updated upstream
    @FXML
    private Label label;
    
    @FXML
=======
    private Label label;
    
>>>>>>> Stashed changes
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
