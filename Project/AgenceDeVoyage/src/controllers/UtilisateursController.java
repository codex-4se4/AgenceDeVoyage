/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import entities.Utilisateur;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
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
    @FXML
    private Circle circleProfil;
    @FXML
    private Circle circleUser;

    private String pathPhoto;

    private int currentUserId;
    @FXML
    private TextField visibleMdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurService = new UtilisateurService();
        circleUser.setFill(new ImagePattern(new Image("/images/defaultUser.png")));
        showUtilisateurs();
    }

    private void showUtilisateurs() {
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
        if (!validateAjoutData()) {
            return;
        }
        Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText(), pathPhoto);
        utilisateurService.ajouter(user);
        clearFields();
        showUtilisateurs();

    }

    private void clearFields() {
        nom.clear();
        prenom.clear();
        email.clear();
        cin.clear();
        passeport.clear();
        login.clear();
        mdp.clear();
        circleUser.setFill(new ImagePattern(new Image("/images/defaultUser.png")));
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
        pathPhoto = "file:///" + selectedUtilisateur.getPhoto().replace(" ", "/");
        Image img = new Image(pathPhoto);
        circleUser.setFill(new ImagePattern(img));

    }

    @FXML
    private void modifierAction(ActionEvent event) {
        if (selectedUtilisateur == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez sélectionner une ligne à modifier");
            alert.showAndWait();
            return;
        }
        if (!validateModificationData()) {
            return;
        }
        Utilisateur user = new Utilisateur(selectedUtilisateur.getId(), nom.getText(), prenom.getText(), email.getText(), cin.getText(), passeport.getText(), login.getText(), mdp.getText(), pathPhoto);
        utilisateurService.modifier(user);
        clearFields();
        showUtilisateurs();

    }

    @FXML
    private void supprimerAction(ActionEvent event) {
        if (selectedUtilisateur == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez sélectionner une ligne à supprimer");
            alert.showAndWait();
            return;
        }
        utilisateurService.supprimer(selectedUtilisateur);
        clearFields();
        showUtilisateurs();

    }

    private boolean isValidEmail(String s) {
        Pattern p = Pattern.compile("^[a-zA-Z-]+@[a-zA-Z-]+\\.[a-zA-Z]{2,6}$");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidTextField(String s) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidNumber(String s) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidAlphaNumeric(String s) {
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isValidLogin(String s) {
        Pattern p = Pattern.compile("^[a-zA-Z][A-Za-z0-9]+");
        Matcher m = p.matcher(s);
        return m.find() && m.group().equals(s);
    }

    private boolean isUniqueLogin(String s) {
        return utilisateurService.getUserByLogin(login.getText()) == null;

    }

    private boolean isUniqueEmail(String s) {
        return utilisateurService.consulterParEmail(email.getText()) == null;

    }

    private boolean validateAjoutData() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        StringBuilder sb = new StringBuilder();
        if (nom.getText().isEmpty()) {
            sb.append("Votre nom est vide " + "\n");
        } else if (!isValidTextField(nom.getText())) {
            sb.append("Votre nom n'est pas valide " + "\n");
        }

        if (prenom.getText().isEmpty()) {
            sb.append("Votre prenom est vide " + "\n");
        } else if (!isValidTextField(prenom.getText())) {
            sb.append("Votre prenom n'est pas valide " + "\n");
        }

        if (email.getText().isEmpty()) {
            sb.append("Votre email est vide " + "\n");
        } else if (!isValidEmail(email.getText())) {
            sb.append("Votre email n'est pas valide " + "\n");
        } else if (!isUniqueEmail(email.getText())) {
            sb.append("Vous avez déjà un compte avec cet email " + "\n");
        }

        if (cin.getText().isEmpty()) {
            sb.append("Votre cin est vide " + "\n");
        } else if (!isValidNumber(cin.getText()) || cin.getText().length() != 8) {
            sb.append("Votre cin n'est pas valide " + "\n");
        }

        if (passeport.getText().isEmpty()) {
            sb.append("Votre passeport est vide " + "\n");
        } else if (!isValidAlphaNumeric(passeport.getText()) || passeport.getText().length() != 6) {
            sb.append("Votre passeport n'est pas valide " + "\n");
        }

        if (login.getText().isEmpty()) {
            sb.append("Votre login est vide " + "\n");
        } else if (!isValidLogin(login.getText()) || login.getText().length() < 4) {
            sb.append("Votre login doit contenir des chiffres et/ou des lettres et doit être supérieur à 4 " + "\n");
        } else if (!isUniqueLogin(login.getText())) {
            sb.append("Votre login existe déjà " + "\n");

        }

        if (mdp.getText().isEmpty()) {
            sb.append("Votre mot de passe est vide " + "\n");
        } else if (!isValidAlphaNumeric(mdp.getText()) || mdp.getText().length() < 4) {
            sb.append("Votre mot de passe doit contenir des chiffres et des lettres et doit être supérieur à 4 " + "\n");
        }

        if (pathPhoto == null) {
            sb.append("Votre photo de profil est vide " + "\n");
        }

        if (sb.length() != 0) {
            alert.setContentText(sb.toString());
            alert.showAndWait();
            return false;
        }

        return true;

    }

    public void setUserInformation(Utilisateur u) throws FileNotFoundException {
        currentUserId = u.getId();
        nomComplet.setText(u.getPrenom() + " " + u.getNom());
        pathPhoto = "file:///" + u.getPhoto().replace(" ", "/");
        Image img = new Image(pathPhoto);
        circleProfil.setFill(new ImagePattern(img));
    }

    @FXML
    private void browseAction(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            pathPhoto = file.getAbsolutePath();
            Image image = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            circleUser.setFill(new ImagePattern(image));

        }
    }

    private boolean validateModificationData() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        StringBuilder sb = new StringBuilder();
        if (nom.getText().isEmpty()) {
            sb.append("Votre nom est vide " + "\n");
        } else if (!isValidTextField(nom.getText())) {
            sb.append("Votre nom n'est pas valide " + "\n");
        }

        if (prenom.getText().isEmpty()) {
            sb.append("Votre prenom est vide " + "\n");
        } else if (!isValidTextField(prenom.getText())) {
            sb.append("Votre prenom n'est pas valide " + "\n");
        }

        if (email.getText().isEmpty()) {
            sb.append("Votre email est vide " + "\n");
        } else if (!isValidEmail(email.getText())) {
            sb.append("Votre email n'est pas valide " + "\n");
        } else if (!(isUniqueEmail(email.getText()) || utilisateurService.consulterParEmail(email.getText()).getId() == currentUserId)) {
            sb.append("Vous avez déjà un compte avec cet email " + "\n");
        }

        if (cin.getText().isEmpty()) {
            sb.append("Votre cin est vide " + "\n");
        } else if (!isValidNumber(cin.getText()) || cin.getText().length() != 8) {
            sb.append("Votre cin n'est pas valide " + "\n");
        }

        if (passeport.getText().isEmpty()) {
            sb.append("Votre passeport est vide " + "\n");
        } else if (!isValidAlphaNumeric(passeport.getText()) || passeport.getText().length() != 6) {
            sb.append("Votre passeport n'est pas valide " + "\n");
        }

        if (login.getText().isEmpty()) {
            sb.append("Votre login est vide " + "\n");
        } else if (!isValidLogin(login.getText()) || login.getText().length() < 4) {
            sb.append("Votre login doit contenir des chiffres et des lettres et doit être supérieur à 4 " + "\n");
        } else if (!(isUniqueLogin(login.getText()) || utilisateurService.getUserByLogin(login.getText()).getId() == currentUserId)) {
            sb.append("Votre login existe déjà " + "\n");

        }

        if (mdp.getText().isEmpty()) {
            sb.append("Votre mot de passe est vide " + "\n");
        } else if (!isValidAlphaNumeric(mdp.getText()) || mdp.getText().length() < 4) {
            sb.append("Votre mot de passe doit contenir des chiffres et/ou des lettres et doit être supérieur à 4 " + "\n");
        }

        if (pathPhoto == null) {
            sb.append("Votre photo de profil est vide " + "\n");
        }

        if (sb.length() != 0) {
            alert.setContentText(sb.toString());
            alert.showAndWait();
            return false;
        }

        return true;

    }

    @FXML
    private void hidePassword(MouseEvent event) {
        mdp.setVisible(true);
        visibleMdp.setVisible(false);
    }

    @FXML
    private void showPassword(MouseEvent event) {
        visibleMdp.setText(mdp.getText());
        mdp.setVisible(false);
        visibleMdp.setVisible(true);

    }

}
