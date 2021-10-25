/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Maison;
import entities.MaisonHote;
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
import services.MaisonHoteService;
import services.MaisonService;

/**
 * FXML Controller class
 *
 * @author Jawher-Louisa
 */
public class MaisonHoteController implements Initializable {

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
    private TableColumn<MaisonHote, Integer> colNombreChambre;
    @FXML
    private TableColumn<MaisonHote, Integer> colNombrePersonnes;
    @FXML
    private TableColumn<MaisonHote, Boolean> colAvecPiscine;
    @FXML
    private TableColumn<MaisonHote, Boolean> colAvecParking;
    @FXML
    private TableColumn<MaisonHote, Boolean> colAvecPlage;
    @FXML
    private TableColumn<MaisonHote, String> colAdresse;
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
    private TableView<MaisonHote> tvMaisonsHote;
    @FXML
    private TableColumn<MaisonHote, Boolean> colAvecPetitDejInclus;
    @FXML
    private CheckBox avecPetitDejInclus;

    private MaisonHoteService maisonHoteService;

    private static int id = 1;

    private MaisonHote selectedMaisonHote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maisonHoteService = new MaisonHoteService();
        showMaisonsHote();
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        try {
            if (nombreChambre.getText().isEmpty() || nombrePersonnes.getText().isEmpty() || adresse.getText().isEmpty()) {
                throw new Exception("Les champs à insérer ne peuvent pas être vides");
            }
            MaisonHote maisonHote = new MaisonHote(avecPetitDejInclus.isSelected(), id++, Integer.parseInt(nombreChambre.getText()),
                    Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
            maisonHoteService.ajouter(maisonHote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nombrePersonnes.clear();
        adresse.clear();
        avecPiscine.setSelected(false);
        avecParking.setSelected(false);
        avecPlage.setSelected(false);
        nombreChambre.clear();
        avecPetitDejInclus.setSelected(false);
        showMaisonsHote();
    }

    @FXML
    private void selectRowAction(MouseEvent event) {
        selectedMaisonHote = tvMaisonsHote.getSelectionModel().getSelectedItem();
        nombrePersonnes.setText(String.valueOf(selectedMaisonHote.getNbPersonnes()));
        adresse.setText(selectedMaisonHote.getAdresse());
        avecPiscine.setSelected(selectedMaisonHote.isAvecPiscine());
        avecParking.setSelected(selectedMaisonHote.isAvecParking());
        avecPlage.setSelected(selectedMaisonHote.isAvecPlage());
        nombreChambre.setText(String.valueOf(selectedMaisonHote.getNbChambres()));
        avecPetitDejInclus.setText(String.valueOf(selectedMaisonHote.isAvecPetitDejInclus()));
    }

    @FXML
    private void modifierAction(ActionEvent event) {
        MaisonHote maisonHote = new MaisonHote(avecPetitDejInclus.isSelected(), id, Integer.parseInt(nombreChambre.getText()),
                Integer.parseInt(nombrePersonnes.getText()), avecPiscine.isSelected(), avecParking.isSelected(), avecPlage.isSelected(), adresse.getText());
        maisonHoteService.modifier(maisonHote);
        showMaisonsHote();
    }

    @FXML
    private void suprrimerAction(ActionEvent event) {
        if (selectedMaisonHote != null) {
            maisonHoteService.supprimer(selectedMaisonHote);
            showMaisonsHote();

        }
    }

    public void showMaisonsHote() {
        ObservableList<MaisonHote> maisonsHote = maisonHoteService.consulter();
        colNombreChambre.setCellValueFactory(new PropertyValueFactory<MaisonHote, Integer>("nbChambres"));
        colNombrePersonnes.setCellValueFactory(new PropertyValueFactory<MaisonHote, Integer>("nbPersonnes"));
        colAvecPiscine.setCellValueFactory(new PropertyValueFactory<MaisonHote, Boolean>("avecPiscine"));
        colAvecParking.setCellValueFactory(new PropertyValueFactory<MaisonHote, Boolean>("avecParking"));
        colAvecPlage.setCellValueFactory(new PropertyValueFactory<MaisonHote, Boolean>("avecPlage"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<MaisonHote, String>("adresse"));
        colAvecPetitDejInclus.setCellValueFactory(new PropertyValueFactory<MaisonHote, Boolean>("avecPetitDejInclus"));
        tvMaisonsHote.setItems(maisonsHote);

    }
}
