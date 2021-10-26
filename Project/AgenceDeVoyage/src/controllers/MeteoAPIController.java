/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import api.WeatherAPI;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author nbelhassen
 */
public class MeteoAPIController implements Initializable {

    @FXML
    private AnchorPane paneHolder;
    @FXML
    private Label nomComplet;
    @FXML
    private TextField cityInput;

    @FXML
    private Text weatherText;

    private String apiWeather = "http://api.weatherapi.com/v1/current.json?key=553947b7b72f4193b9b134507212610%20&q=Tunisia&aqi=no";
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void getWeatherData(ActionEvent event) throws MalformedURLException {
        //JSONObject todaysWeather = GetTodaysWeatherInformation(getWoeid());

        //System.out.println(todaysWeather);
        weatherText.setText(
                getLocation().get("name").toString() + " "
                + getWeatherInformation().get("temp_c")
        );
        String url = "https:" + getImage().get("icon").toString();
        Image img = new Image(url);
        image.setImage(img);


        /*weatherText.setText(
                "Min temperature: " + todaysWeather.get("min_temp")
                + "\nCurrent temperature: " + todaysWeather.get("the_temp")
                + "\nMax temperature: " + todaysWeather.get("max_temp")
        );*/
    }

    public String getWoeid() throws MalformedURLException {
        WeatherAPI apiConnectorCity = new WeatherAPI(apiWeather);

        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray()).get(0);

        return jsonData.get("woeid").toString();
    }

    public JSONObject GetTodaysWeatherInformation(String woeid) throws MalformedURLException {
        WeatherAPI apiConnectorWeather = new WeatherAPI(apiWeather);

        JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject();

        JSONArray weatherArray = (JSONArray) weatherJSONObject.get("consolidated_weather");

        return (JSONObject) weatherArray.get(0);
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

}
