/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author bourg
 */
public class MotDePasseOublieController implements Initializable {

    @FXML
    private JFXButton envoyer;
    @FXML
    private JFXTextField email;

    UtilisateurService utilisateurService;
    @FXML
    private Label emailControl;

    private final int MIN = 10000;
    private final int MAX = 99999;
    @FXML
    private JFXButton annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        email.setStyle("-fx-text-inner-color : #a0a2ab;" + "-fx-prompt-text-fill : #a0a2ab;");
        utilisateurService = new UtilisateurService();
    }

    @FXML
    private void envoyerAction(ActionEvent event) throws Exception {
        if (email.getText().isEmpty()) {
            emailControl.setVisible(true);
            emailControl.setText("Veuillez saisir votre email de récupération");
            return;
        }

        Utilisateur utilisateur = utilisateurService.consulterParEmail(email.getText());
        if (utilisateur == null) {
            emailControl.setVisible(true);
            emailControl.setText("Aucun utilisateur n'existe avec l'email saisi");
            return;

        }
        final String username = "TunisiaTrip2021@gmail.com";
        final String password = "123456789aA&";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "username");
        properties.put("mail.smtp.password", "password");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", true);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        int generatedPassword = (int) (Math.random() * (MAX - MIN + 1) + MIN);
        Message message = prepareMessage(session, username, password, generatedPassword);
        Transport.send(message);
        utilisateur.setMdp(String.valueOf(generatedPassword));
        utilisateurService.modifier(utilisateur);
        emailControl.setVisible(false);
        envoyer.getScene().getWindow().hide();
        Stage signUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene scene = new Scene(root);
        signUp.setScene(scene);
        signUp.show();
        signUp.setResizable(false);

    }

    @FXML
    private void annulerAction(ActionEvent event) throws IOException {
        envoyer.getScene().getWindow().hide();
        Stage signIn = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene scene = new Scene(root);
        signIn.setScene(scene);
        signIn.show();
        signIn.setResizable(false);
    }

    private Message prepareMessage(Session session, String username, String password, int generatedPassword) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getText()));
            message.setSubject("Tunisia Trip - Récuperation de mot de passe");
            message.setText("Voici votre nouveau mot de passe de récupération " + generatedPassword);
            return message;

        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return null;
    }

}
