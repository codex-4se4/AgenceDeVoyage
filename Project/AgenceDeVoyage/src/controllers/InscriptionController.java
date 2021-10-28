/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateur;
import services.UtilisateurService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    UtilisateurService utilisateurService;
    @FXML
    private ImageView progress;
    private String pathPhoto;
    @FXML
    private Circle circle;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField login;
    @FXML
    private TextField email;
    @FXML
    private TextField cin;
    @FXML
    private TextField passeport;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField passwordText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurService = new UtilisateurService();
        progress.setVisible(false);
        nom.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        prenom.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        email.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        login.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        mdp.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        cin.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        passeport.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        Image image = new Image("/images/defaultUser.png");
        circle.setFill(new ImagePattern(image));

    }

    @FXML
    private void creerCompteAction(ActionEvent event) {
        if (!validateData()) {
            return;
        }
        Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText(), pathPhoto);
        utilisateurService.ajouter(user);

        progress.setVisible(true);
        nom.clear();
        prenom.clear();
        email.clear();
        cin.clear();
        passeport.clear();
        login.clear();
        mdp.clear();
        pathPhoto = null;
        circle.setFill(new ImagePattern(new Image("/images/defaultUser.png")));

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

    private boolean isValidEmail(String s) {
        Pattern p = Pattern.compile("^[a-zA-Z-]+@[a-zA-Z-]+\\.[a-zA-Z]{2,6}$");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidTextField(String s) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidNumber(String s) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidAlphaNumeric(String s) {
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidLogin(String s) {
        Pattern p = Pattern.compile("^[a-zA-Z][A-Za-z0-9]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isUniqueLogin(String s) {
        return utilisateurService.getUserByLogin(login.getText()) == null;

    }

    private boolean isUniqueEmail(String s) {
        return utilisateurService.consulterParEmail(email.getText()) == null;

    }

    private boolean validateData() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        StringBuilder sb = new StringBuilder();
        if (nom.getText().isEmpty()) {
            sb.append("Votre nom est vide " + "\n");
        } else if (!isValidTextField(nom.getText())) {
            sb.append("Votre nom n'est pas valide " + "\n");
        }

        if (prenom.getText().isEmpty()) {
            sb.append("Votre prenom est vide " + "\n");
        } else if (!isValidTextField(prenom.getText())) {
            sb.append("Votre prenom n'est pas valide " + "\n");
        }

        if (email.getText().isEmpty()) {
            sb.append("Votre email est vide " + "\n");
        } else if (!isValidEmail(email.getText())) {
            sb.append("Votre email n'est pas valide " + "\n");
        } else if (!isUniqueEmail(email.getText())) {
            sb.append("Vous avez déjà un compte avec cet email " + "\n");
        }

        if (cin.getText().isEmpty()) {
            sb.append("Votre cin est vide " + "\n");
        } else if (!isValidNumber(cin.getText()) || cin.getText().length() != 8) {
            sb.append("Votre cin n'est pas valide " + "\n");
        }

        if (passeport.getText().isEmpty()) {
            sb.append("Votre passeport est vide " + "\n");
        } else if (!isValidAlphaNumeric(passeport.getText()) || passeport.getText().length() != 6) {
            sb.append("Votre passeport n'est pas valide " + "\n");
        }

        if (login.getText().isEmpty()) {
            sb.append("Votre login est vide " + "\n");
        } else if (!isValidLogin(login.getText()) || login.getText().length() < 4) {
            sb.append("Votre login doit contenir des chiffres et/ou des lettres et doit être supérieur à 4 " + "\n");
        } else if (!isUniqueLogin(login.getText())) {
            sb.append("Votre login existe déjà " + "\n");

        }

        if (mdp.getText().isEmpty()) {
            sb.append("Votre mot de passe est vide " + "\n");
        } else if (!isValidAlphaNumeric(mdp.getText()) || mdp.getText().length() < 4) {
            sb.append("Votre mot de passe doit contenir des chiffres et des lettres et doit être supérieur à 4 " + "\n");
        }

        if (pathPhoto == null) {
            sb.append("Votre photo de profil est vide " + "\n");
        }

        if (sb.length() != 0) {
            alert.setContentText(sb.toString());
            alert.showAndWait();
            return false;
        }

        return true;

    }

    @FXML
    private void hidePassword(MouseEvent event) {
        mdp.setVisible(true);
        passwordText.setVisible(false);
    }

    @FXML
    private void showPassword(MouseEvent event) {
        passwordText.setText(mdp.getText());
        mdp.setVisible(false);
        passwordText.setVisible(true);

    }
}
