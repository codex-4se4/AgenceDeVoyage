/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author bourg
 */
public class AgenceDeVoyage extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< Updated upstream
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
=======
             Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
>>>>>>> Stashed changes
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
<<<<<<< Updated upstream
=======
        stage.setResizable(false);
  
       
>>>>>>> Stashed changes
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
