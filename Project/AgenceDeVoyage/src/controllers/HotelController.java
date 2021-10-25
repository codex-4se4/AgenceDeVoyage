/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Hotel;
import entities.Maison;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.HotelService;
import services.MaisonService;

/**
 * FXML Controller class
 *
 * @author Jawher-Louisa
 */
public class HotelController implements Initializable {

    @FXML
    private AnchorPane paneHolder;
    @FXML
    private Label nomComplet;
    @FXML
    private TextField nombreChambre;
    @FXML
    private TextField nombrePersonnes;
    @FXML
    private TextField adresse;
    @FXML
    private JFXButton ajouterButton;
    @FXML
    private TableView<Hotel> tvHotels;
    @FXML
    private TableColumn<Hotel, Integer> colNombreChambre;
    @FXML
    private TableColumn<Hotel, Integer> colNombrePersonnes;
    @FXML
    private TableColumn<Hotel, Boolean> colAvecPiscine;
    @FXML
    private TableColumn<Hotel, Boolean> colAvecParking;
    @FXML
    private TableColumn<Hotel, Boolean> colAvecPlage;
    @FXML
    private TableColumn<Hotel, String> colAdresse;
    @FXML
    private JFXButton modifierButton;
    @FXML
    private JFXButton supprimerButton;
    @FXML
    private CheckBox avecPiscine;
    @FXML
    private CheckBox avecParking;
    @FXML
    private CheckBox avecPlage;
    @FXML
    private TextField nombreEtoile;
    @FXML
    private TableColumn<Hotel, Integer> colNbEtoiles;

    private HotelService hotelService;

    private static int id = 1;

    private Hotel selectedHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hotelService = new HotelService();
        showHotels();
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        try {
            if (nombreChambre.getText().isEmpty() || nombrePersonnes.getText().isEmpty() || adresse.getText().isEmpty() || nombreEtoile.getText().isEmpty()) {
                throw new Exception("Les champs à insérer ne peuvent pas être vides");
            }
            Hotel hotel = new Hotel(Integer.parseInt(nombreEtoile.getText()), id++, Integer.parseInt(nombreChambre.getText()),
                    Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
            hotelService.ajouter(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nombrePersonnes.clear();
        adresse.clear();
        avecPiscine.setSelected(false);
        avecParking.setSelected(false);
        avecPlage.setSelected(false);
        nombreChambre.clear();
        nombreEtoile.clear();
        showHotels();
    }

    @FXML
    private void selectRowAction(MouseEvent event) {
        selectedHotel = tvHotels.getSelectionModel().getSelectedItem();
        nombrePersonnes.setText(String.valueOf(selectedHotel.getNbPersonnes()));
        adresse.setText(selectedHotel.getAdresse());
        avecPiscine.setSelected(selectedHotel.isAvecPiscine());
        avecParking.setSelected(selectedHotel.isAvecParking());
        avecPlage.setSelected(selectedHotel.isAvecPlage());
        nombreChambre.setText(String.valueOf(selectedHotel.getNbChambres()));
        nombreEtoile.setText(String.valueOf(selectedHotel.getNbEtoiles()));
    }

    @FXML
    private void modifierAction(ActionEvent event) {
        Hotel hotel = new Hotel(Integer.parseInt(nombreEtoile.getText()), id, Integer.parseInt(nombreChambre.getText()),
                Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
        hotelService.modifier(hotel);
        showHotels();
    }

    @FXML
    private void suprrimerAction(ActionEvent event) {
        if (selectedHotel != null) {
            hotelService.supprimer(selectedHotel);
            showHotels();

        }
    }

    public void showHotels() {
        ObservableList<Hotel> hotels = hotelService.consulter();
        colNombreChambre.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbChambres"));
        colNombrePersonnes.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbPersonnes"));
        colAvecPiscine.setCellValueFactory(new PropertyValueFactory<Hotel, Boolean>("avecPiscine"));
        colAvecParking.setCellValueFactory(new PropertyValueFactory<Hotel, Boolean>("avecParking"));
        colAvecPlage.setCellValueFactory(new PropertyValueFactory<Hotel, Boolean>("avecPlage"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Hotel, String>("adresse"));
        colNbEtoiles.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbEtoiles"));
        tvHotels.setItems(hotels);

    }
}
