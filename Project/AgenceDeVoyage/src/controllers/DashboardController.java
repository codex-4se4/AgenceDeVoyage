/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import api.WeatherAPI;
import com.jfoenix.controls.JFXButton;
import entities.Utilisateur;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.simple.JSONObject;

/**
 *
 * @author danml
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane holderPane;

    AnchorPane utilisateurs, profiles;

    private FXMLLoader profilLoader, utilisateursLoader;
    @FXML
    private JFXButton btnUtilisateurs;
    @FXML
    private JFXButton btnDeconnect;

    private String apiWeather = "http://api.weatherapi.com/v1/current.json?key=553947b7b72f4193b9b134507212610%20&q=Tunisia&aqi=no";
    @FXML
    private ImageView image;
    @FXML
    private Text weatherText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            weatherText.setText(
                    getLocation().get("name").toString() + " "
                    + getWeatherInformation().get("temp_c") + "°C"
            );
        } catch (MalformedURLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String path = null;
        try {
            path = "https:" + getImage().get("icon").toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image img = new Image(path);
        image.setImage(img);
        //Load all fxmls in a cache
        try {
            utilisateursLoader = new FXMLLoader(getClass().getResource("/gui/Utilisateurs.fxml"));
            utilisateurs = utilisateursLoader.load();
            profilLoader = new FXMLLoader(getClass().getResource("/gui/Profil.fxml"));
            profiles = profilLoader.load();
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
    private void switchUtilisateurs(ActionEvent event) {
        setNode(utilisateurs);
    }

    public void setCurrentUser(Utilisateur u) throws FileNotFoundException {
        ProfilController profilController = profilLoader.getController();
        profilController.setUserInformation(u);
        UtilisateursController utilisateursController =utilisateursLoader.getController();
        utilisateursController.setUserInformation(u);
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

    public JSONObject getLocation() throws MalformedURLException {
        WeatherAPI apiConnectorWeather = new WeatherAPI(apiWeather);

        return (JSONObject) apiConnectorWeather.getJSONObject().get("location");

    }

    public JSONObject getWeatherInformation() throws MalformedURLException {
        WeatherAPI apiConnectorWeather = new WeatherAPI(apiWeather);

        return (JSONObject) apiConnectorWeather.getJSONObject().get("current");

    }

    public JSONObject getImage() throws MalformedURLException {
        JSONObject weatherInfo = getWeatherInformation();
        return (JSONObject) weatherInfo.get("condition");
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        setNode(profiles);
    }
}
