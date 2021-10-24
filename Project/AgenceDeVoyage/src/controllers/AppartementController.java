/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Appartement;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.AppartementService;

/**
 * FXML Controller class
 *
 * @author Jawher-Louisa
 */
public class AppartementController implements Initializable {

    @FXML
    private AnchorPane paneHolder;
    @FXML
    private TextField nombrePersonnes;
    @FXML
    private TextField adresse;
    @FXML
    private TableColumn<Appartement, Integer> colNombreChambre;
    @FXML
    private TableColumn<Appartement, Integer> colNombrePersonnes;
    @FXML
    private TableColumn<Appartement, Boolean> colAvecPiscine;
    @FXML
    private TableColumn<Appartement, Boolean> colAvecParking;
    @FXML
    private TableColumn<Appartement, Boolean> colAvecPlage;
    @FXML
    private TableColumn<Appartement, String> colAdresse;
    @FXML
    private TableColumn<Appartement, Integer> colNumeroEtage;
    @FXML
    private TableColumn<Appartement, Boolean> colAvecAscenseur;
    @FXML
    private CheckBox avecPiscine;
    @FXML
    private CheckBox avecParking;
    @FXML
    private CheckBox avecPlage;
    @FXML
    private CheckBox avecAscenseur;
    @FXML
    private JFXButton ajouterButton;
    @FXML
    private JFXButton modifierButton;
    @FXML
    private JFXButton supprimerButton;

    private AppartementService appartementService;
    @FXML
    private Label nomComplet;
    @FXML
    private Label mdpLabel;
    @FXML
    private TableView<Appartement> tvAppartements;

    private static int id = 1;
    @FXML
    private TextField numeroEtage;
    @FXML
    private TextField nombreChambre;

    private Appartement selectedAppartement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        appartementService = new AppartementService();
        showAppartements();
    }

    @FXML
    private void selectRowAction(MouseEvent event) {
        selectedAppartement = tvAppartements.getSelectionModel().getSelectedItem();
        nombrePersonnes.setText(String.valueOf(selectedAppartement.getNbPersonnes()));
        adresse.setText(selectedAppartement.getAdresse());
        avecPiscine.setSelected(selectedAppartement.isAvecPiscine());
        avecParking.setSelected(selectedAppartement.isAvecParking());
        avecPlage.setSelected(selectedAppartement.isAvecPlage());
        numeroEtage.setText(String.valueOf(selectedAppartement.getNumeroEtage()));
        avecAscenseur.setSelected(selectedAppartement.isAvecAscenseur());
        nombreChambre.setText(String.valueOf(selectedAppartement.getNbChambres()));

    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        try {
            if (nombreChambre.getText().isEmpty() || nombrePersonnes.getText().isEmpty() || adresse.getText().isEmpty() || numeroEtage.getText().isEmpty()) {
                throw new Exception("Les champs à insérer ne peuvent pas être vides");
            }
            Appartement appartement = new Appartement(Integer.parseInt(numeroEtage.getText()), avecAscenseur.isSelected(), id++, Integer.parseInt(nombreChambre.getText()),
                    Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
            appartementService.ajouter(appartement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nombrePersonnes.clear();
        adresse.clear();
        avecPiscine.setSelected(false);
        avecParking.setSelected(false);
        avecPlage.setSelected(false);
        numeroEtage.clear();
        nombreChambre.clear();
        avecAscenseur.setSelected(false);
        showAppartements();
    }

    @FXML
    private void modifierAction(ActionEvent event) {
        Appartement appartement = new Appartement(Integer.parseInt(numeroEtage.getText()), avecAscenseur.isSelected(), id, Integer.parseInt(nombreChambre.getText()),
                Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
        appartementService.modifier(appartement);
        showAppartements();
    }

    @FXML
    private void suprrimerAction(ActionEvent event) {
        if (selectedAppartement != null) {
            appartementService.supprimer(selectedAppartement);
            showAppartements();

        }
    }

    public void showAppartements() {
        ObservableList<Appartement> appartements = appartementService.consulter();
        colNombreChambre.setCellValueFactory(new PropertyValueFactory<Appartement, Integer>("nbChambres"));
        colNombrePersonnes.setCellValueFactory(new PropertyValueFactory<Appartement, Integer>("nbPersonnes"));
        colAvecPiscine.setCellValueFactory(new PropertyValueFactory<Appartement, Boolean>("avecPiscine"));
        colAvecParking.setCellValueFactory(new PropertyValueFactory<Appartement, Boolean>("avecParking"));
        colAvecPlage.setCellValueFactory(new PropertyValueFactory<Appartement, Boolean>("avecPlage"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Appartement, String>("adresse"));
        colNumeroEtage.setCellValueFactory(new PropertyValueFactory<Appartement, Integer>("numeroEtage"));
        colAvecAscenseur.setCellValueFactory(new PropertyValueFactory<Appartement, Boolean>("avecAscenseur"));
        tvAppartements.setItems(appartements);

    }

}
