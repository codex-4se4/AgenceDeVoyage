/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author bourg
 */
public class UtilisateursController implements Initializable {

    @FXML
    private AnchorPane paneHolder;
    @FXML
    private Label nomComplet;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField cin;
    @FXML
    private TextField passeport;
    @FXML
    private TextField login;
    @FXML
    private Label mdpLabel;
    @FXML
    private TextField mdp;
    @FXML
    private TableColumn<Utilisateur, String> colNom;
    @FXML
    private TableColumn<Utilisateur, String> colPrenom;
    @FXML
    private TableColumn<Utilisateur, String> colEmail;
    @FXML
    private TableColumn<Utilisateur, String> colCin;
    @FXML
    private TableColumn<Utilisateur, String> colPasseport;
    @FXML
    private TableColumn<Utilisateur, String> colLogin;

    private UtilisateurService utilisateurService;
    @FXML
    private TableView<Utilisateur> tvUtilisateurs;
    @FXML
    private JFXButton ajouterButton;
    @FXML
    private JFXButton modifierButton;
    @FXML
    private JFXButton supprimerButton;

    private Utilisateur selectedUtilisateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurService = new UtilisateurService();
        showUtilisateurs();
    }

    public void showUtilisateurs() {
        ObservableList<Utilisateur> utilisateurs = utilisateurService.consulter();
        colNom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        colCin.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("cin"));
        colPasseport.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("passeport"));
        colLogin.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("login"));
        tvUtilisateurs.setItems(utilisateurs);

    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        try {
            if (nom.getText().isEmpty() || prenom.getText().isEmpty() || email.getText().isEmpty()
                    || cin.getText().isEmpty() || passeport.getText().isEmpty() 
                    || login.getText().isEmpty() || mdp.getText().isEmpty()) {
                throw new Exception("Les champs à insérer ne peuvent pas être vides");
            }
            Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText(),null);
            utilisateurService.ajouter(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nom.clear();
        prenom.clear();
        email.clear();
        cin.clear();
        passeport.clear();
        login.clear();
        mdp.clear();
        showUtilisateurs();

    }

    @FXML
    private void selectRowAction(MouseEvent event) {
        selectedUtilisateur = tvUtilisateurs.getSelectionModel().getSelectedItem();
        nom.setText(selectedUtilisateur.getNom());
        prenom.setText(selectedUtilisateur.getPrenom());
        cin.setText(selectedUtilisateur.getCin());
        email.setText(selectedUtilisateur.getEmail());
        login.setText(selectedUtilisateur.getLogin());
        passeport.setText(selectedUtilisateur.getPasseport());

    }

    @FXML
    private void modifierAction(ActionEvent event) {
        Utilisateur user = new Utilisateur(selectedUtilisateur.getId(), nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText(),null);

        utilisateurService.modifier(user);
        showUtilisateurs();

    }

    @FXML
    private void suprrimerAction(ActionEvent event) {
        if (selectedUtilisateur != null) {
            utilisateurService.supprimer(selectedUtilisateur);
            showUtilisateurs();

        }
    }

}
