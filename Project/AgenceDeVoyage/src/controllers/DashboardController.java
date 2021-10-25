/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author danml
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXButton btnPricing;
    @FXML
    private JFXButton btnContacts;
    @FXML
    private JFXButton btnAlerts;

    AnchorPane utilisateurs, alerts, pricing, profiles, appartements, controls, maisons, maisonsHote, hotels;
    @FXML
    private JFXButton btnControls;

    private FXMLLoader loader;
    @FXML
    private JFXButton btnContacts21;
    @FXML
    private JFXButton btnUtilisateurs;
    @FXML
    private JFXButton btnContacts2;
    @FXML
    private JFXButton btnDeconnect;
    @FXML
    private JFXButton btnAppartement;
    @FXML
    private JFXButton btnMaison;
    @FXML
    private JFXButton btnMaisonHote;
    @FXML
    private JFXButton btnHôtel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        try {
            utilisateurs = FXMLLoader.load(getClass().getResource("/gui/Utilisateurs.fxml"));
            alerts = FXMLLoader.load(getClass().getResource("/gui/Alerts.fxml"));
            pricing = FXMLLoader.load(getClass().getResource("/gui/Pricing.fxml"));
            loader = new FXMLLoader(getClass().getResource("/gui/Profil.fxml"));
            profiles = loader.load();
            appartements = FXMLLoader.load(getClass().getResource("/gui/Appartement.fxml"));
            maisons = FXMLLoader.load(getClass().getResource("/gui/Maison.fxml"));
            maisonsHote = FXMLLoader.load(getClass().getResource("/gui/MaisonHote.fxml"));
            controls = FXMLLoader.load(getClass().getResource("/gui/Controls.fxml"));
            hotels = FXMLLoader.load(getClass().getResource("/gui/Hotel.fxml"));

            setNode(profiles);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchPricing(ActionEvent event) {
        setNode(pricing);
    }

    @FXML
    private void switchUtilisateurs(ActionEvent event) {
        setNode(utilisateurs);
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        setNode(profiles);
    }

    @FXML
    private void switchAlert(ActionEvent event) {
        setNode(alerts);
    }

    @FXML
    private void switchControls(ActionEvent event) {
        setNode(controls);
    }

    @FXML
    private void switchAppartement(ActionEvent event) {
        setNode(appartements);
    }

    public void setCurrentUser(Utilisateur u) {
        ProfilController profilController = loader.getController();
        profilController.setUserInformation(u);
    }

    @FXML
    private void switchContacts(ActionEvent event) {
    }

    @FXML
    private void deconnectAction(ActionEvent event) throws IOException {
        holderPane.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene scene = new Scene(root, 607, 409);
        login.setScene(scene);
        login.show();
        login.setResizable(false);

    }

    @FXML
    private void switchMaison(ActionEvent event) {
        setNode(maisons);

    }

    @FXML
    private void switchMaisonHote(ActionEvent event) {
        setNode(maisonsHote);

    }

    @FXML
    private void switchHotel(ActionEvent event) {
        setNode(hotels);

    }

}
