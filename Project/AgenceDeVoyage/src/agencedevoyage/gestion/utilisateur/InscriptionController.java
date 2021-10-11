/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.gestion.utilisateur;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bourg
 */
public class InscriptionController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField login;
    @FXML
    private JFXPasswordField mdp;
    @FXML
    private JFXTextField cin;
    @FXML
    private JFXTextField passeport;
    
    UtilisateurService utilisateurService;
    @FXML
    private ImageView progress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       progress.setVisible(false);
       nom.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       prenom.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       email.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       login.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       mdp.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       cin.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       passeport.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       utilisateurService = new UtilisateurService();
    }

    @FXML
    private void creerCompteAction(ActionEvent event) {
        try {
           Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText());
           utilisateurService.ajouter(user); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        progress.setVisible(true);
        nom.clear();
        prenom.clear();
        email.clear();
        cin.clear();
        passeport.clear();
        login.clear();
        mdp.clear();
        
        
    }

    @FXML
    private void authentifierAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage signIn = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/agencedevoyage/Main.fxml"));
        Scene scene = new Scene(root);
        signIn.setScene(scene);
        signIn.show();
        signIn.setResizable(false);
    }
    
}
