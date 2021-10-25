/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Appartement;
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
import services.AppartementService;
import services.MaisonService;

/**
 * FXML Controller class
 *
 * @author Jawher-Louisa
 */
public class MaisonController implements Initializable {

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
    private Label mdpLabel;
    @FXML
    private JFXButton ajouterButton;
    @FXML
    private TableColumn<Maison, Integer> colNombreChambre;
    @FXML
    private TableColumn<Maison, Integer> colNombrePersonnes;
    @FXML
    private TableColumn<Maison, Boolean> colAvecPiscine;
    @FXML
    private TableColumn<Maison, Boolean> colAvecParking;
    @FXML
    private TableColumn<Maison, Boolean> colAvecPlage;
    @FXML
    private TableColumn<Maison, String> colAdresse;
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
    private TextField surfaceJardin;
    @FXML
    private TableView<Maison> tvMaisons;
    @FXML
    private TableColumn<Maison, Float> colSurfaceJardin;

    private MaisonService maisonService;

    private static int id = 1;

    private Maison selectedMaison;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maisonService = new MaisonService();
        showMaisons();
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        try {
            if (nombreChambre.getText().isEmpty() || nombrePersonnes.getText().isEmpty() || adresse.getText().isEmpty() || surfaceJardin.getText().isEmpty()) {
                throw new Exception("Les champs à insérer ne peuvent pas être vides");
            }
            Maison maison = new Maison(Float.parseFloat(surfaceJardin.getText()), id++, Integer.parseInt(nombreChambre.getText()),
                    Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
            maisonService.ajouter(maison);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nombrePersonnes.clear();
        adresse.clear();
        avecPiscine.setSelected(false);
        avecParking.setSelected(false);
        avecPlage.setSelected(false);
        nombreChambre.clear();
        surfaceJardin.clear();
        showMaisons();
    }

    @FXML
    private void selectRowAction(MouseEvent event) {
        selectedMaison = tvMaisons.getSelectionModel().getSelectedItem();
        nombrePersonnes.setText(String.valueOf(selectedMaison.getNbPersonnes()));
        adresse.setText(selectedMaison.getAdresse());
        avecPiscine.setSelected(selectedMaison.isAvecPiscine());
        avecParking.setSelected(selectedMaison.isAvecParking());
        avecPlage.setSelected(selectedMaison.isAvecPlage());
        nombreChambre.setText(String.valueOf(selectedMaison.getNbChambres()));
        surfaceJardin.setText(String.valueOf(selectedMaison.getSurfaceJardin()));
    }

    @FXML
    private void modifierAction(ActionEvent event) {
        Maison maison = new Maison(Float.parseFloat(surfaceJardin.getText()), id, Integer.parseInt(nombreChambre.getText()),
                Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
        maisonService.modifier(maison);
        showMaisons();
    }

    @FXML
    private void suprrimerAction(ActionEvent event) {
        if (selectedMaison != null) {
            maisonService.supprimer(selectedMaison);
            showMaisons();

        }
    }

    public void showMaisons() {
        ObservableList<Maison> maisons = maisonService.consulter();
        colNombreChambre.setCellValueFactory(new PropertyValueFactory<Maison, Integer>("nbChambres"));
        colNombrePersonnes.setCellValueFactory(new PropertyValueFactory<Maison, Integer>("nbPersonnes"));
        colAvecPiscine.setCellValueFactory(new PropertyValueFactory<Maison, Boolean>("avecPiscine"));
        colAvecParking.setCellValueFactory(new PropertyValueFactory<Maison, Boolean>("avecParking"));
        colAvecPlage.setCellValueFactory(new PropertyValueFactory<Maison, Boolean>("avecPlage"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Maison, String>("adresse"));
        colSurfaceJardin.setCellValueFactory(new PropertyValueFactory<Maison, Float>("surfaceJardin"));
        tvMaisons.setItems(maisons);

    }
}
