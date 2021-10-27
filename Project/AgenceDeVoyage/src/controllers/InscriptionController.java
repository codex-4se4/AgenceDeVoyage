/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateur;
import services.UtilisateurService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

// remember me consomamtion API &&&&&  mot de passe haché sur la BD
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
    private String pathPhoto;
    @FXML
    private Circle circle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progress.setVisible(false);
        nom.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        prenom.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        email.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        login.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        mdp.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        cin.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        passeport.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        utilisateurService = new UtilisateurService();
        Image image = new Image("/images/defaultUser.png");
        circle.setFill(new ImagePattern(image));

    }

    @FXML
    private void creerCompteAction(ActionEvent event) {
        try {
            Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText(), pathPhoto);
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
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene scene = new Scene(root);
        signIn.setScene(scene);
        signIn.show();
        signIn.setResizable(false);
    }

    @FXML
    private void browseAction(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("JPG", "*.jpg"), new ExtensionFilter("PNG", "*.png"),
                new ExtensionFilter("JPEG", "*.jpeg"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            pathPhoto = file.getAbsolutePath();
            Image image = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            circle.setFill(new ImagePattern(image));

        }
    }

}
