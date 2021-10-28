/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.UtilisateurService;

/**
 *
 * @author bourg
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXButton login;
    @FXML
    private JFXCheckBox remember;
    @FXML
    private ImageView progress;
    @FXML
    private Label echec;

    private Preferences preferences;
    @FXML
    private JFXButton motDePasseOublie;

    private UtilisateurService utilisateurService;

    private Utilisateur currenUtilisateur;

    @FXML
    private void connexionAction(ActionEvent e) throws SQLException, IOException {
        if (!validateData()) {
            return;
        }
        progress.setVisible(true);
        if (remember.isSelected()) {
            preferences.put("username", username.getText());
            preferences.put("password", password.getText());

        } else {
            preferences.put("username", "");
            preferences.put("password", "");
        }
        login.getScene().getWindow().hide();
        Stage dashboard = new Stage();
        Integer idRole = utilisateurService.getRole(currenUtilisateur.getId());
        FXMLLoader loader = new FXMLLoader(idRole == 1
                ? getClass().getResource("/gui/Dashboard.fxml")
                : getClass().getResource("/gui/UserDashboard.fxml"));
        Parent root = (Parent) loader.load();

        if (idRole == 1) {
            ((DashboardController) loader.getController()).setCurrentUser(currenUtilisateur);
        } else {
            ((UserDashboardController) loader.getController()).setCurrentUser(currenUtilisateur);
        }

        Scene scene = new Scene(root);
        dashboard.setScene(scene);
        dashboard.show();
        dashboard.setResizable(false);
        dashboard.setMaximized(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurService = new UtilisateurService();
        progress.setVisible(false);
        echec.setVisible(false);
        username.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        password.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        preferences = Preferences.userNodeForPackage(LoginController.class);
        username.setText(preferences.get("username", ""));
        password.setText(preferences.get("password", ""));
    }

    @FXML
    private void inscriptionAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage signUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Inscription.fxml"));
        Scene scene = new Scene(root);
        signUp.setScene(scene);
        signUp.show();
        signUp.setResizable(false);
    }

    @FXML
    private void motDePasseOublieAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage motDePasseOublie = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/MotDePasseOublie.fxml"));
        Scene scene = new Scene(root);
        motDePasseOublie.setScene(scene);
        motDePasseOublie.show();
        motDePasseOublie.setResizable(false);
    }

    private boolean validateData() {
        StringBuilder sb = new StringBuilder();

        if (username.getText().isEmpty()) {
            sb.append("Votre login est vide " + "\n");
        }

        if (password.getText().isEmpty()) {
            sb.append("Votre password est vide " + "\n");
        }

        if (sb.length() != 0) {
            echec.setVisible(true);
            echec.setText(sb.toString());
            return false;
        } else {
            currenUtilisateur = utilisateurService.getUserByLoginAndPassword(username.getText(), password.getText());
            if (currenUtilisateur == null) {
                echec.setVisible(true);
                echec.setText("Login et/ou mot de passe erroné(s)");
                return false;

            }

            return true;

        }

    }

}
