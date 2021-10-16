/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author bourg
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXButton login;
    @FXML
    private JFXCheckBox remember;
    @FXML
    private JFXButton forgotpassword;
    @FXML
    private ImageView progress;
    @FXML
    private Label echec;

    @FXML
    private void connexionAction(ActionEvent e) throws SQLException, IOException {
        progress.setVisible(true);
        String SQL = "SELECT * FROM `utilisateur` WHERE login= "+"'" + username.getText() + "' AND mdp='" + password.getText() +"'";
        ResultSet rs;
        
            rs = loginQuery(SQL);
            if(rs == null || !rs.next()){
                
                echec.setVisible(true);

                return;
            }       
        login.getScene().getWindow().hide();
        Stage dashboard = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Dashboard.fxml"));
        Scene scene = new Scene(root);
        dashboard.setScene(scene);
        dashboard.show();
        dashboard.setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       progress.setVisible(false);
       echec.setVisible(false);
       username.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
       password.setStyle("-fx-text-inner-color : #a0a2ab;"+"-fx-prompt-text-fill : #a0a2ab;");
    }

    @FXML
    private void inscriptionAction(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Inscription.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }
    
     private ResultSet loginQuery(String query) {
        Connection conn = DBConnection.getInstance().getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
        return rs;
    }

}
