/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage.configuration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bourg
 */
public class DBConnection {
    
    private static DBConnection instance;
    private Connection cnx;
    String url = "jdbc:mysql://localhost:3306/agenceDeVoyage";

    private DBConnection() {
        try {
            cnx = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return cnx;
    }
    
}
